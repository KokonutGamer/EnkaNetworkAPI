package me.kazury.enkanetworkapi.enka;

import me.kazury.enkanetworkapi.genshin.data.GenshinLocalization;
import me.kazury.enkanetworkapi.genshin.util.INameable;
import org.jetbrains.annotations.NotNull;

/**
 * A builder which is used for creating an {@link EnkaNetworkAPI} instance.
 *
 * <br><br><b>Example</b>:
 * <pre>{@code
 * final EnkaNetworkAPI api = new EnkaNetworkBuilder()
 *                 .setDefaultLocalization(GenshinLocalization.GERMAN)
 *                 .setUserAgent("My User Agent")
 *                 .build();
 * }</pre>
 */
public class EnkaNetworkBuilder {
    private GenshinLocalization defaultLocalization;
    private String baseUrl;
    private String userAgent;

    /**
     * Sets the default localization which will be used for {@link INameable} objects.
     * @param localization The "new" default localization. Leaving this empty will be english.
     */
    @NotNull
    public EnkaNetworkBuilder setDefaultLocalization(@NotNull GenshinLocalization localization) {
        this.defaultLocalization = localization;
        return this;
    }

    /**
     * Sets the base URl for the API.
     * <br>This must have the full path, with https.
     * @param baseUrl The new base URL (which is used to grab images).
     */
    @NotNull
    public EnkaNetworkBuilder setBaseUrl(@NotNull String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    /**
     * Sets the user agent which will be used for HTTP requests.
     * @param agent The new user agent, prefer this to be your package name, or something else which identifies you.
     */
    @NotNull
    public EnkaNetworkBuilder setUserAgent(@NotNull String agent) {
        this.userAgent = agent;
        return this;
    }

    /**
     * Builds the {@link EnkaNetworkAPI} instance.
     * @return The {@link EnkaNetworkAPI} instance.
     */
    @NotNull
    public EnkaNetworkAPI build() {
        final EnkaNetworkAPI api = new EnkaNetworkAPI();
        if (this.defaultLocalization != null) {
            api.setDefaultLocalization(this.defaultLocalization);
        }

        if (this.baseUrl != null) {
            api.setDefaultUIPath(this.baseUrl);
        }

        if (this.userAgent != null) {
            api.setUserAgent(this.userAgent);
        }

        return api;
    }
}
