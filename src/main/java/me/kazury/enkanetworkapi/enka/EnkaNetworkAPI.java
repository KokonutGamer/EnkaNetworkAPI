package me.kazury.enkanetworkapi.enka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.kazury.enkanetworkapi.genshin.data.*;
import me.kazury.enkanetworkapi.genshin.data.conversion.GenshinUnconvertedUser;
import me.kazury.enkanetworkapi.genshin.util.GenshinNameable;
import me.kazury.enkanetworkapi.starrail.data.conversion.SRUnconvertedUser;
import me.kazury.enkanetworkapi.util.GlobalLocalization;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * The main API instance for retreving data from enka.network.
 * <br>You will need to this class to get data from the API.
 *
 * <br>
 * <br>Example
 * <pre>{@code
 * final EnkaNetworkAPI api = new EnkaNetworkAPI();
 *
 * api.fetchGenshinUser(722777337, (user) -> {
 *      final GenshinUserInformation genshinUser = user.toGenshinUser();
 *      // do action here
 * });
 * }</pre>
 */
public class EnkaNetworkAPI {
    public static String BASE_GENSHIN_UI_URL = "https://enka.network/ui/";
    public static String BASE_SR_UI_URL = "https://enka.network/ui/hsr/";

    private final Gson gson;
    private final EnkaHTTPClient httpClient;

    public EnkaNetworkAPI() {
        this.gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
        this.httpClient = new EnkaHTTPClient(this, this.gson);
    }

    /**
     * Loads a genshin user from the Enka Network API and passes on the action that you want to do on the user.
     * @param uid The <a href="https://genshin-impact.fandom.com/wiki/UID">UID</a> of the user.
     * @param consumer The action that you want to do on the user once the data has been acquired.
     *                 This method is async and the request will be queued to avoid spamming the API.
     */
    public void fetchGenshinUser(final long uid, @NotNull Consumer<GenshinUnconvertedUser> consumer) {
        this.httpClient.fetchGenshinUser(uid, consumer);
    }

    /**
     * Loads a genshin user from the Enka Network API and passes on the action that you want to do on the user.
     * @param uid The <a href="https://genshin-impact.fandom.com/wiki/UID">UID</a> of the user.
     * @param success The action that you want to do on the user once the data has been acquired.
     *                 This method is async and the request will be queued to avoid spamming the API.
     * @param failure The action that you want to do when the request fails (exception status).
     */
    public void fetchGenshinUser(final long uid, @NotNull Consumer<GenshinUnconvertedUser> success,
                          @NotNull Consumer<Throwable> failure) {
        this.httpClient.fetchGenshinUser(uid, success, failure);
    }

    /**
     * Loads a genshin user from the Enka Network API and passes on the action that you want to do on the user.
     * @param uid The <a href="https://genshin-impact.fandom.com/wiki/UID">UID</a> of the user.
     * @param consumer The action that you want to do on the user once the data has been acquired.
     *                 This method is async and the request will be queued to avoid spamming the API.
     */
    public void fetchGenshinUser(@NotNull String uid, @NotNull Consumer<GenshinUnconvertedUser> consumer) {
        this.fetchGenshinUser(Long.parseLong(uid), consumer);
    }

    /**
     * Loads a genshin user from the Enka Network API and passes on the action that you want to do on the user.
     * @param uid The <a href="https://genshin-impact.fandom.com/wiki/UID">UID</a> of the user.
     * @param consumer The action that you want to do on the user once the data has been acquired.
     *                 This method is async and the request will be queued to avoid spamming the API.
     * @param failure The action that you want to do when the request fails (exception status).
     */
    public void fetchGenshinUser(@NotNull String uid, @NotNull Consumer<GenshinUnconvertedUser> consumer,
                          @NotNull Consumer<Throwable> failure) {
        this.fetchGenshinUser(Long.parseLong(uid), consumer, failure);
    }

    /**
     * Loads a honkai user from the Enka Network API and passes on the action that you want to do on the user.
     * @param uid The UID of the user.
     * @param consumer The action that you want to do on the user once the data has been acquired.
     *                 This method is async and the request will be queued to avoid spamming the API.
     */
    public void fetchHonkaiUser(final long uid, @NotNull Consumer<SRUnconvertedUser> consumer) {
        this.httpClient.fetchHonkaiUser(uid, consumer);
    }

    /**
     * Loads a honkai user from the Enka Network API and passes on the action that you want to do on the user.
     * @param uid The UID of the user.
     * @param success The action that you want to do on the user once the data has been acquired.
     *                 This method is async and the request will be queued to avoid spamming the API.
     * @param failure The action that you want to do when the request fails (exception status).
     */
    public void fetchHonkaiUser(final long uid, @NotNull Consumer<SRUnconvertedUser> success,
                          @NotNull Consumer<Throwable> failure) {
        this.httpClient.fetchHonkaiUser(uid, success, failure);
    }

    /**
     * Loads a honkai user from the Enka Network API and passes on the action that you want to do on the user.
     * @param uid The UID of the user.
     * @param consumer The action that you want to do on the user once the data has been acquired.
     *                 This method is async and the request will be queued to avoid spamming the API.
     */
    public void fetchHonkaiUser(@NotNull String uid, @NotNull Consumer<SRUnconvertedUser> consumer) {
        this.fetchHonkaiUser(Long.parseLong(uid), consumer);
    }

    /**
     * Loads a honkai user from the Enka Network API and passes on the action that you want to do on the user.
     * @param uid The UID of the user.
     * @param consumer The action that you want to do on the user once the data has been acquired.
     *                 This method is async and the request will be queued to avoid spamming the API.
     * @param failure The action that you want to do when the request fails (exception status).
     */
    public void fetchHonkaiUser(@NotNull String uid, @NotNull Consumer<SRUnconvertedUser> consumer,
                          @NotNull Consumer<Throwable> failure) {
        this.fetchHonkaiUser(Long.parseLong(uid), consumer, failure);
    }

    /**
     * Fetches the namecard with an id.
     * <br>Namecard IDs are always provided where you need them.
     * @param id The ID of the namecard.
     * @return The namecard, or null if the namecard does not exist (or I forgot to update my library)
     */
    @Nullable
    public GenshinNamecard getGenshinNamecard(final int id) {
        return EnkaCaches.hasNamecard(id) ? new GenshinNamecard(id, this.getGenshinIcon(EnkaCaches.getNamecardName(id))) : null;
    }

    /**
     * Fetches the character data of a user.
     * @param id The ID of the character. This is not the character's name.
     * @return The character data, or null if the character does not exist (or I forgot to update my library)
     */
    @Nullable
    public GenshinCharacterData getCharacterData(@NotNull String id) {
        return EnkaCaches.getCharacterData(id);
    }

    /**
     * Gets all the characters that are currently in the game.
     * <br>This list will not contain characters that are not in the library yet.
     * <br>In that case, you must update
     * @return All Genshin characters
     */
    @NotNull
    public List<GenshinCharacterData> getAllGenshinCharacters() {
        return EnkaCaches.getCharacterMap().values().stream().toList();
    }

    /**
     * Returns the total amount of set artifacts this character has.
     *
     * @param character The character to get the total amount of set artifacts from.
     * @return A map of artifacts this character has.
     */
    @NotNull
    public Map<String, Integer> getGenshinArtifactTotal(@NotNull GenshinUserCharacter character) {
        final Map<String, Integer> artifacts = new HashMap<>();
        for (GenshinArtifact artifact : character.getArtifacts()) {
            artifacts.put(artifact.getName(), artifacts.getOrDefault(artifact.getName(), 0) + 1);
        }
        return artifacts;
    }

    /**
     * Sets the default localization.
     * <br>You might notice, some methods with translation require you to pass in a translation, but you can also decide to not put any parameters,
     * and so the default translation will be used (which will be english).
     * @param localization The default localization.
     * @see GenshinNameable
     */
    public void setDefaultLocalization(@NotNull GlobalLocalization localization) {
        EnkaGlobals.setDefaultLocalization(localization);
        EnkaCaches.loadLocalizations(localization);
    }

    /**
     * Sets the user agent for the HTTP requests when fetching {@link GenshinUnconvertedUser}.
     * <br><b>Quote: </b><i>Please set a custom User-Agent header with your requests so I can track them better and help you if needed.</i>
     * @param userAgent The user agent.
     */
    public void setUserAgent(@NotNull String userAgent) {
        this.httpClient.setUserAgent(userAgent);
    }

    /**
     * Sets the default UI path.
     * <br>By default, this is set to <a href="https://enka.network/ui/">The default Enka URL</a>
     * <br>However, if you want to use something like ambr to get the icons, you can set this to your own path.
     * @param path The default UI path.
     */
    public void setDefaultUIPath(@NotNull String path) {
        BASE_GENSHIN_UI_URL = path;
    }

    /**
     * Fetches the character data of a user.
     * @param id The ID of the character. This is not the character's name.
     * @return The character data, or null if the character does not exist (or I forgot to update my library)
     */
    @Nullable
    public GenshinCharacterData getGenshinCharacterData(final long id) {
        return this.getCharacterData(String.valueOf(id));
    }

    /**
     * Gets a material from the game by an id.
     * @param id The id of the material
     * @return The material or null if the material does not exist
     */
    @Nullable
    public GenshinMaterial getGenshinMaterial(@NotNull String id) {
        return EnkaCaches.getMaterial(Integer.parseInt(id));
    }

    /**
     * Gets a material from the game by an id.
     * @param id The id of the material
     * @return The material or null if the material does not exist
     */
    @Nullable
    public GenshinMaterial getGenshinMaterial(final int id) {
        return EnkaCaches.getMaterial(id);
    }

    /**
     * Gets an icon by the icon id (genshin impact)
     * @param key The icon id, it is usually an uppercase char sequence
     * @return The icon url or null if the icon does not exist
     */
    @Nullable
    public String getGenshinIcon(@NotNull String key) {
        return BASE_GENSHIN_UI_URL + key + ".png";
    }

    /**
     * Gets an icon by the icon id (Honkai: Star Rail)
     * @param key The icon id, it is usually an uppercase char sequence
     * @return The icon url or null (see note)
     * @apiNote Only images that are available on enka.network are imported, so something like a banner will not work.
     *         <br>However, if you need those images, you can use {@link #setDefaultUIPath(String)} to set your own path
     *         <br>With a custom CDN.
     */
    @Nullable
    public String getSRIcon(@NotNull String key) {
        return BASE_SR_UI_URL + key + ".png";
    }
}