package se.lexicon;

@FunctionalInterface
public interface Action {
    void execute(Product p);
}
