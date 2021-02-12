package com.litts.lib.worm;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;

public interface Repository<I, E extends Entity<I>, C, D> {

    void create(@NotNull E entity);

    default void createAll(@NotNull E... entities) {
        for (E entity : entities) {
            create(entity);
        }
    }

    default void createAll(@NotNull Collection<E> entities) {
        entities.forEach(this::create);
    }

    @Nullable <T extends E> T read(@NotNull Class<T> type, @NotNull I identifier, @Nullable String... fields);

    @NotNull
    default <T extends E> List<T> readAll(@NotNull Class<T> type, @Nullable String... fields) {
        return readWhere(type, null, fields);
    }

    @NotNull <T extends E> List<T> readWhere(@NotNull Class<T> type, @Nullable C conditions, @Nullable String... fields);

    default long count(@NotNull Class<? extends E> type) {
        return countWhere(type, null);
    }

    long countWhere(@NotNull Class<? extends E> type, @Nullable C conditions);

    void update(@NotNull E entity, @Nullable String... fields);

    default void updateAll(@NotNull E[] entities, @Nullable String... fields) {
        for (E entity : entities) {
            update(entity, fields);
        }
    }

    default void updateAll(@NotNull Collection<? extends E> entities, @Nullable String... fields) {
        entities.forEach(entity -> update(entity, fields));
    }

    void updateWhere(@NotNull Class<? extends E> type, @Nullable C conditions, @NotNull D data);

    void delete(@NotNull E entity);

    default void deleteAll(@NotNull E... entities) {
        for (E entity : entities) {
            delete(entity);
        }
    }

    default void deleteAll(@NotNull Collection<? extends E> entities) {
        entities.forEach(this::delete);
    }

    default void deleteType(@NotNull Class<? extends E> type) {
        deleteWhere(type, null);
    }

    void deleteWhere(@NotNull Class<? extends E> type, @Nullable C conditions);

}
