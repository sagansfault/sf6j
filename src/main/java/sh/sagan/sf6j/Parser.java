package sh.sagan.sf6j;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    private static final HttpClient CLIENT = HttpClient.newBuilder().build();

    static final class MoveParser {

        private static final String IDENTIFIER_SELECTOR = "div > div > section.section-collapsible > h5 > span.mw-headline";
        private static final String MOVE_BLOCK_IDENTIFIER = "div > div > section.section-collapsible > h5 + table.wikitable";

        private static final String INPUT_SELECTOR = "tr > th > div > p > span";
        private static final String NAME_SELECTOR = "tr > th > div > div";
        private static final String HITBOX_IMAGE_ELEMENT_SELECTOR = "tr > th > a";
        private static final Pattern HITBOX_IMAGE_URL_PATTERN = Pattern.compile("(/images/thumb\\S+) 2x");
        private static final String DATA_ROW_SELECTOR = "tr > td";

        private static final String DEFAULT_IMAGE_URL = "https://wiki.supercombo.gg/images/thumb/4/42/SF6_Logo.png/300px-SF6_Logo.png";

        public static CompletableFuture<List<Move>> loadMoves(String url) {
            HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
            return CLIENT.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(res -> {
                        String body = res.body();
                        Document document = Jsoup.parse(body);
                        return parseMoves(document);
                    });
        }

        private static List<Move> parseMoves(Document document) {
            List<Move> moves = new ArrayList<>();
            Iterator<Element> identifierIterator = selectIdentifierElements(document);
            Iterator<Element> moveIterator = selectMoveElements(document);
            while (identifierIterator.hasNext() && moveIterator.hasNext()) {
                moves.add(parseMove(identifierIterator.next(), moveIterator.next()));
            }
            return moves;
        }

        private static Move parseMove(Element identifierElement, Element moveElement) {
            String identifier = identifierElement.ownText();
            String input = firstOrDefault(moveElement.select(INPUT_SELECTOR));
            String name = firstOrDefault(moveElement.select(NAME_SELECTOR));
            String image = getImageURL(moveElement);

            Iterator<Element> iterator = moveElement.select(DATA_ROW_SELECTOR).iterator();
            String damage = consumeNextOrEmpty(iterator);
            String chipDamage = consumeNextOrEmpty(iterator);
            String damageScaling = consumeNextOrEmpty(iterator);
            String guard = consumeNextOrEmpty(iterator);
            String cancel = consumeNextOrEmpty(iterator);
            String hitconfirmWindow = consumeNextOrEmpty(iterator);
            String startup = consumeNextOrEmpty(iterator);
            String active = consumeNextOrEmpty(iterator);
            String recovery = consumeNextOrEmpty(iterator);
            String total = consumeNextOrEmpty(iterator);
            String hitstun = consumeNextOrEmpty(iterator);
            String blockstun = consumeNextOrEmpty(iterator);
            String driveDamageBlock = consumeNextOrEmpty(iterator);
            String driveDamageHit = consumeNextOrEmpty(iterator);
            String driveGain = consumeNextOrEmpty(iterator);
            String superGainHit = consumeNextOrEmpty(iterator);
            String superGainBlock = consumeNextOrEmpty(iterator);
            String projectileSpeed = consumeNextOrEmpty(iterator);
            String invuln = consumeNextOrEmpty(iterator);
            String armor = consumeNextOrEmpty(iterator);
            String airborne = consumeNextOrEmpty(iterator);
            String juggleStart = consumeNextOrEmpty(iterator);
            String juggleIncrease = consumeNextOrEmpty(iterator);
            String juggleLimit = consumeNextOrEmpty(iterator);
            String perfectParryAdvantage = consumeNextOrEmpty(iterator);
            String afterDriveRushHit = consumeNextOrEmpty(iterator);
            String afterDriveRushBlock = consumeNextOrEmpty(iterator);
            String driveRushCancelHit = consumeNextOrEmpty(iterator);
            String driveRushCancelBlock = consumeNextOrEmpty(iterator);
            String punishAdvantage = consumeNextOrEmpty(iterator);
            String hitAdvantage = consumeNextOrEmpty(iterator);
            String blockAdvantage = consumeNextOrEmpty(iterator);
            String notes = consumeNextOrEmpty(iterator);

            return new Move(identifier, input, name, image, damage, chipDamage, damageScaling, guard, cancel, hitconfirmWindow,
                    startup, active, recovery, total, hitstun, blockstun, driveDamageBlock, driveDamageHit, driveGain,
                    superGainHit, superGainBlock, projectileSpeed, invuln, armor, airborne, juggleStart, juggleIncrease,
                    juggleLimit, perfectParryAdvantage, afterDriveRushHit, afterDriveRushBlock, driveRushCancelHit,
                    driveRushCancelBlock, punishAdvantage, hitAdvantage, blockAdvantage, notes);
        }

        private static String getImageURL(Element moveElement) {
            Elements images = moveElement.select(HITBOX_IMAGE_ELEMENT_SELECTOR);
            Element image = images.first();
            Element hitboxImage = images.size() < 2 ? null : images.get(1);
            String rawImageText;
            if (hitboxImage != null) {
                rawImageText = hitboxImage.outerHtml();
            } else if (image != null) {
                rawImageText = image.outerHtml();
            } else {
                return DEFAULT_IMAGE_URL;
            }
            Matcher matcher = HITBOX_IMAGE_URL_PATTERN.matcher(rawImageText);
            if (!matcher.find()) {
                return DEFAULT_IMAGE_URL;
            }
            if (matcher.groupCount() < 1) {
                return DEFAULT_IMAGE_URL;
            }
            String path = matcher.group(1);
            return java.lang.String.format("https://wiki.supercombo.gg%s", path);
        }

        private static Iterator<Element> selectIdentifierElements(Document document) {
            return document.select(IDENTIFIER_SELECTOR).iterator();
        }

        private static Iterator<Element> selectMoveElements(Document document) {
            return document.select(MOVE_BLOCK_IDENTIFIER).iterator();
        }

        private static String consumeNextOrEmpty(Iterator<Element> iterator) {
            if (iterator.hasNext()) {
                return getLowestChild(iterator.next()).ownText();
            }
            return "";
        }
    }

    private static String firstOrDefault(Elements elements) {
        return Optional.ofNullable(elements.first()).map(Element::ownText).orElse("");
    }

    private static Element getLowestChild(Element element) {
        Element first = element.firstElementChild();
        if (first == null) {
            return element;
        } else {
            return getLowestChild(first);
        }
    }
}
