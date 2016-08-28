package com.jakewharton.rxbinding.support.v4.widget;

import android.support.annotation.NonNull;
import android.support.v4.widget.SlidingPaneLayout;

import com.jakewharton.rxbinding.view.ViewEvent;

/**
 *
 * Created by musa on 8/2/16.
 */
public class SlidingPaneLayoutSlideEvent extends ViewEvent<SlidingPaneLayout> {
    protected SlidingPaneLayoutSlideEvent(@NonNull SlidingPaneLayout view) {
        super(view);
    }
}
