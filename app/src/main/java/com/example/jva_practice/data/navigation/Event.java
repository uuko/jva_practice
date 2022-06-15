package com.example.jva_practice.data.navigation;

public class Event<T> {
    private T content;

    private boolean hasBeenHandled = false;

    public Event(T content) {
        this.content = content;
    }

    /**
     * Returns the content and prevents its use again.
     */
    T getContentIfNotHandled() {
        if (hasBeenHandled) {
            return null;
        } else {
            hasBeenHandled = true;
            return content;
        }
    }

    /**
     * Returns the content, even if it's already been handled.
     */
    T peekContent() {
        return content;
    }
}
