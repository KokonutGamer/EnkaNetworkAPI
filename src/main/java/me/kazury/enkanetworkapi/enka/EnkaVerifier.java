package me.kazury.enkanetworkapi.enka;

import me.kazury.enkanetworkapi.util.exceptions.HonkaiNotEnabledException;
import org.jetbrains.annotations.NotNull;

/**
 * A verifier class which is used to verify conditions before executing code.
 */
public class EnkaVerifier {
    /**
     * Verifies a condition, if the condition is false, it will throw an exception.
     * @param condition the condition
     * @param exception the exception
     */
    public static <E extends Exception> void verifyOrThrow(final boolean condition, @NotNull Class<E> exception) throws E {
        if (condition) return;

        try {
            throw exception.getDeclaredConstructor().newInstance();
        } catch (ReflectiveOperationException | IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Verifies if honkai is enabled, this is run before all Honkai: Star Rail operations.
     */
    public static void verifyHonkai() {
        verifyOrThrow(EnkaGlobals.isHonkaiEnabled(), HonkaiNotEnabledException.class);
    }
}
