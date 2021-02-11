package com.litts.lib.worm;

import org.jetbrains.annotations.NotNull;

public interface DataAccess<R extends Repository<?, ?, ?,  ?>> extends AutoCloseable{

    @NotNull R getRepository();
    boolean isOpen();
    void reset();

}
