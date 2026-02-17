package packageFiles;

public final class Money {
    private final long cents;

    public Money(long cents) {
        if (cents < 0) {
            throw new IllegalArgumentException("Amount must be >= 0");
        }
        this.cents = cents;
    }

    public static Money zero() {
        return new Money(0);
    }

    public static Money ofDollars(double dollars) {
        return new Money(Math.round(dollars * 100));
    }

    public Money add(Money other) {
        return new Money(this.cents + other.cents);
    }

    public Money multiply(int factor) {
        return new Money(this.cents * factor);
    }

    public Money multiply(double factor) {
        return new Money(Math.round(this.cents * factor));
    }

    public long cents() {
        return cents;
    }

    @Override
    public String toString() {
        return String.format("$%.2f", cents / 100.0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return cents == money.cents;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(cents);
    }
}
