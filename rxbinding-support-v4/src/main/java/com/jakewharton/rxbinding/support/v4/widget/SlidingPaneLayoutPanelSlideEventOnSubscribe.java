package com.jakewharton.rxbinding.support.v4.widget;

import android.support.v4.widget.SlidingPaneLayout;
import android.view.View;
import com.jakewharton.rxbinding.support.v4.widget.SlidingPaneLayoutSlideEvent.Kind;
import android.support.v4.widget.SlidingPaneLayout.PanelSlideListener;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

import static rx.android.MainThreadSubscription.verifyMainThread;

public class SlidingPaneLayoutPanelSlideEventOnSubscribe implements Observable.OnSubscribe<SlidingPaneLayoutSlideEvent> {
    final SlidingPaneLayout slidingPaneLayout;

    SlidingPaneLayoutPanelSlideEventOnSubscribe(SlidingPaneLayout slidingPaneLayout) {
        this.slidingPaneLayout = slidingPaneLayout;
    }

    @Override
    public void call(final Subscriber<? super SlidingPaneLayoutSlideEvent> subscriber) {
        verifyMainThread();

        final PanelSlideListener listener = new PanelSlideListener() {
            @Override
            public void onPanelClosed(View panel) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext(SlidingPaneLayoutSlideEvent.create(slidingPaneLayout, Kind.CLOSED, panel));
                }

            }

            @Override
            public void onPanelOpened(View panel) {

            }

            @Override
            public void onPanelSlide(View panel, float slideOffset) {

            }
        };
        slidingPaneLayout.setPanelSlideListener(listener);
        subscriber.add(new MainThreadSubscription() {
            @Override protected void onUnsubscribe() {
                slidingPaneLayout.setPanelSlideListener(null);
            }
        });
    }
}
