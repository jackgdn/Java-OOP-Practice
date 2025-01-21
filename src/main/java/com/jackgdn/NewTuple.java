package com.jackgdn;

import java.util.List;

@SuppressWarnings("unchecked")
public class NewTuple<T extends Number> {
    public List<T> values;

    public NewTuple() {
    }

    public NewTuple(List<T> values) {
        this.values = values;
    }

    public int size() {
        return values.size();
    }

    public NewTuple<T> add(NewTuple<T> other) {
        for (int i = 0; i < Math.min(this.size(), other.size()); i++) {
            Number thisValue = this.values.get(i);
            Number otherValue = other.values.get(i);

            if (thisValue instanceof Integer) {
                this.values.set(i, (T) (Number) (thisValue.intValue() + otherValue.intValue()));
            } else if (thisValue instanceof Double) {
                this.values.set(i, (T) (Number) (thisValue.doubleValue() + otherValue.doubleValue()));
            } else if (thisValue instanceof Float) {
                this.values.set(i, (T) (Number) (thisValue.floatValue() + otherValue.floatValue()));
            } else if (thisValue instanceof Long) {
                this.values.set(i, (T) (Number) (thisValue.longValue() + otherValue.longValue()));
            } else if (thisValue instanceof Short) {
                this.values.set(i, (T) (Number) (thisValue.shortValue() + otherValue.shortValue()));
            } else if (thisValue instanceof Byte) {
                this.values.set(i, (T) (Number) (thisValue.byteValue() + otherValue.byteValue()));
            } else {
                throw new UnsupportedOperationException();
            }
        }

        return this;
    }

    public NewTuple<T> sub(NewTuple<T> other) {
        for (int i = 0; i < Math.min(this.size(), other.size()); i++) {
            Number thisValue = this.values.get(i);
            Number otherValue = other.values.get(i);

            if (thisValue instanceof Integer) {
                this.values.set(i, (T) (Number) (thisValue.intValue() - otherValue.intValue()));
            } else if (thisValue instanceof Double) {
                this.values.set(i, (T) (Number) (thisValue.doubleValue() - otherValue.doubleValue()));
            } else if (thisValue instanceof Float) {
                this.values.set(i, (T) (Number) (thisValue.floatValue() - otherValue.floatValue()));
            } else if (thisValue instanceof Long) {
                this.values.set(i, (T) (Number) (thisValue.longValue() - otherValue.longValue()));
            } else if (thisValue instanceof Short) {
                this.values.set(i, (T) (Number) (thisValue.shortValue() - otherValue.shortValue()));
            } else if (thisValue instanceof Byte) {
                this.values.set(i, (T) (Number) (thisValue.byteValue() - otherValue.byteValue()));
            } else {
                throw new UnsupportedOperationException();
            }
        }

        return this;
    }

    public NewTuple<T> mul(NewTuple<T> other) {
        for (int i = 0; i < Math.min(this.size(), other.size()); i++) {
            Number thisValue = this.values.get(i);
            Number otherValue = other.values.get(i);

            if (thisValue instanceof Integer) {
                this.values.set(i, (T) (Number) (thisValue.intValue() * otherValue.intValue()));
            } else if (thisValue instanceof Double) {
                this.values.set(i, (T) (Number) (thisValue.doubleValue() * otherValue.doubleValue()));
            } else if (thisValue instanceof Float) {
                this.values.set(i, (T) (Number) (thisValue.floatValue() * otherValue.floatValue()));
            } else if (thisValue instanceof Long) {
                this.values.set(i, (T) (Number) (thisValue.longValue() * otherValue.longValue()));
            } else if (thisValue instanceof Short) {
                this.values.set(i, (T) (Number) (thisValue.shortValue() * otherValue.shortValue()));
            } else if (thisValue instanceof Byte) {
                this.values.set(i, (T) (Number) (thisValue.byteValue() * otherValue.byteValue()));
            } else {
                throw new UnsupportedOperationException();
            }
        }

        return this;
    }

    public NewTuple<T> div(NewTuple<T> other) {
        for (int i = 0; i < Math.min(this.size(), other.size()); i++) {
            if (other.values.get(i).doubleValue() == 0.0) {
                throw new ArithmeticException("/ by zero");
            }
        }

        for (int i = 0; i < Math.min(this.size(), other.size()); i++) {
            Number thisValue = this.values.get(i);
            Number otherValue = other.values.get(i);

            if (thisValue instanceof Integer) {
                this.values.set(i, (T) (Number) (thisValue.intValue() / otherValue.intValue()));
            } else if (thisValue instanceof Double) {
                this.values.set(i, (T) (Number) (thisValue.doubleValue() / otherValue.doubleValue()));
            } else if (thisValue instanceof Float) {
                this.values.set(i, (T) (Number) (thisValue.floatValue() / otherValue.floatValue()));
            } else if (thisValue instanceof Long) {
                this.values.set(i, (T) (Number) (thisValue.longValue() / otherValue.longValue()));
            } else if (thisValue instanceof Short) {
                this.values.set(i, (T) (Number) (thisValue.shortValue() / otherValue.shortValue()));
            } else if (thisValue instanceof Byte) {
                this.values.set(i, (T) (Number) (thisValue.byteValue() / otherValue.byteValue()));
            } else {
                throw new UnsupportedOperationException();
            }
        }

        return this;
    }

    public String toString() {
        return values.toString();
    }
}