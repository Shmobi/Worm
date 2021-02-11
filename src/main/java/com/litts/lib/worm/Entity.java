package com.litts.lib.worm;

import org.jetbrains.annotations.NotNull;

public interface Entity<I> {

   @NotNull I getIdentifier();

}
