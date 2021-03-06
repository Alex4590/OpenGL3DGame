package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

/**
 * Настройки отображения
 */
public class DisplayManager {

    /**
     * Ширина окна
     */
    private static final int WIDTH = 720;

    /**
     * Высота окна
     */
    private static final int HEIGHT = 450;

    /**
     * Количество кадров в секунду
     */
    private static final int FPS_CAP = 120;

    /**
     * Создание окна отображения
     */
    public static void createDisplay() {
        ContextAttribs attribs = new ContextAttribs(3, 2)
                .withForwardCompatible(true)
                .withProfileCore(true);

        try {
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.create(new PixelFormat(), attribs);
            Display.setTitle("Our First Display!");
        } catch (LWJGLException e) {
            e.printStackTrace();
        }

        GL11.glViewport(0, 0, WIDTH, HEIGHT);
    }

    /**
     * Обновление окна отображения
     */
    public static void updateDisplay() {
        Display.sync(FPS_CAP);
        Display.update();
    }

    /**
     * Закрытие окна отображения
     */
    public static void closeDisplay() {
        Display.destroy();
    }
}
