
package com.evan.uilstep;

/**
 * copy from
 * {@link androidx.arch.core.util.Function}
 * <p>
 * Represents a function.
 * Type parameters:
 * <I> – the type of the input to the function
 * <O> – the type of the output of the function
 *
 */
public interface Function<I, O> {
    /**
     * Applies this function to the given input.
     *
     * @param input the input
     * @return the function result.
     */
    O apply(I input);
}
