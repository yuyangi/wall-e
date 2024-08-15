package org.free13.rubik.coder;

/**
 * @author free13
 * Copyright (c) 2024.
 */
public interface RCoder<S> {

    String coding(S source, String packages);

    S decoding(String code);

    String language();

}
