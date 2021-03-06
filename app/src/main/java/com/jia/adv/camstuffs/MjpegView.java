package com.jia.adv.camstuffs;

public interface MjpegView {

    void setSource(MjpegInputStream stream);

    void setDisplayMode(DisplayMode mode);

    void showFps(boolean show);

    void stopPlayback();

    boolean isStreaming();

    void setResolution(int width, int height);

    void freeCameraMemory();

}
