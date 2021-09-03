package com.eugenebaturov.rickandmorty.utils;

import io.reactivex.rxjava3.core.Scheduler;

/**
 * Интерфейс, который предоставляет шедулеры.
 */
public interface SchedulerProvider {

    /**
     * Шедулер фонового потока
     *
     * @return поток ввода-ввывода(input-output)
     */
    Scheduler io();

    /**
     * Шедулер основного потока
     *
     * @return ui-поток.
     */
    Scheduler ui();
}
