package com.springinaction.springidol;

/**
 * Created by atursunov on 22.12.16.
 */
public class Stage {
    private Stage() {
    }
    private static class StageSingletonHolder {
        static Stage instance = new Stage(); // Создание экземпляра
    }
    public static Stage getInstance() {
        return StageSingletonHolder.instance; // Возвращает экземпляр
    }
}
