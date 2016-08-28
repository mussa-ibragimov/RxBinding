package com.jakewharton.rxbinding.support.v4.widget;

import android.support.annotation.NonNull;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.View;

import com.jakewharton.rxbinding.view.ViewEvent;

/**
 *
 * Created by musa on 8/2/16.
 */
public class SlidingPaneLayoutSlideEvent extends ViewEvent<SlidingPaneLayout> {

    public static SlidingPaneLayoutSlideEvent create(SlidingPaneLayout slidingPaneLayout, Kind kind, View panel) {
        return new SlidingPaneLayoutSlideEvent(slidingPaneLayout, kind, 0, panel);
    }

    public static SlidingPaneLayoutSlideEvent create(SlidingPaneLayout slidingPaneLayout, Kind kind, float slideOffset, View panel) {
        return new SlidingPaneLayoutSlideEvent(slidingPaneLayout, kind, slideOffset, panel);
    }

    public enum Kind {
        CLOSED,
        OPENED,
        SLIDE
    }

    private final Kind kind;
    private final float slideOffset;
    private final View panel;

    private SlidingPaneLayoutSlideEvent(@NonNull SlidingPaneLayout view, @NonNull Kind kind, float slideOffset, @NonNull View panel) {
        super(view);
        this.kind = kind;
        this.slideOffset = slideOffset;
        this.panel = panel;
    }

    @NonNull
    public Kind kind() {
        return kind;
    }

    public float slideOffset() {
        return slideOffset;
    }

    @NonNull
    public View panel() {
        return panel;
    }

    @Override public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof SlidingPaneLayoutSlideEvent)) return false;
        SlidingPaneLayoutSlideEvent other = (SlidingPaneLayoutSlideEvent) o;
        return view() == other.view()
                && kind == other.kind
                && slideOffset == other.slideOffset
                && panel == other.panel;
    }

    @Override public int hashCode() {
        int result = 17;
        result = result * 37 + view().hashCode();
        result = result * 37 + kind().hashCode();
        result = result * 37 + (int) (slideOffset * 100);
        result = result * 37 + panel.hashCode();
        return result;
    }

    @Override public String toString() {
        return "SlidingPaneLayoutSlideEvent{view=" + view() + ", kind=" + kind() + ", panel=" + panel() + ", slideOffset=" + slideOffset() + '}';
    }
}