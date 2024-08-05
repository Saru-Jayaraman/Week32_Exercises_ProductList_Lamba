package se.lexicon;

@FunctionalInterface
public interface Conditional {
    boolean test(Product p);
}
