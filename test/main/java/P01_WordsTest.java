import org.junit.jupiter.api.*;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class P01_WordsTest {

    private P01_Words student;

    @BeforeEach
    void beforeEach() {
        student = new P01_Words();
    }

    @Test
    @Order(1)
    void shortWords() {
        var list1 = TestList.of("hippest", "quake", "reception's", "Edison's", "weatherman", "sellouts", "sambaing", "cyan", "megaphoned", "Hafiz's", "circumscribing", "synthesizing", "sour's", "Coulomb's", "mania", "paraprofessional", "Transvaal", "clods", "unspeakably", "impersonation's");
        var result = student.shortWords(list1);

        assertTrue(result == list1.collected, "List returned was not result of .collect()");
        assertEquals(List.of("quake", "cyan", "mania", "clods"), result);
        assertTrue(1 == list1.streamCounter.count, "words.stream() should've been called exactly once");
        assertTrue(1 == list1.filterCounter.count, ".filter() should've been called exactly once");
        assertTrue(0 == list1.mapCounter.count, ".map() should not have been called");
        assertTrue(0 == list1.sortedCounter.count, ".sorted() should not have been called");
        assertTrue(0 == list1.otherCounter.count, "Only .filter() should've been called");

        var list2 = TestList.of("airbrushes", "Charleston", "rechristen", "Ni's", "furthest", "lamentably", "cheerfulness", "temerity", "dishonorably", "Nova's", "performed", "arrears's", "dressmaking", "reinvigorate", "Magog's", "recast", "rationalized", "vintners", "bath's");
        result = student.shortWords(list2);
        assertTrue(result == list2.collected, "List returned was not result of .collect()");
        assertEquals(List.of("Ni's"), result);
        assertTrue(1 == list2.streamCounter.count, "words.stream() should've been called exactly once");
        assertTrue(1 == list2.filterCounter.count, ".filter() should've been called exactly once");
        assertTrue(0 == list2.mapCounter.count, ".map() should not have been called");
        assertTrue(0 == list2.sortedCounter.count, ".sorted() should not have been called");
        assertTrue(0 == list2.otherCounter.count, "Only .filter() should've been called");
    }

    @Test
    @Order(2)
    void pigLatin() {
        var list1 = TestList.of("hiking", "splendider", "grammarians", "stationer", "duvalier");
        var result = student.pigLatin(list1);

        assertTrue(result == list1.collected, "List returned was not result of .collect()");
        assertEquals(List.of("ikinghay", "plendidersay", "rammariansgay", "tationersay", "uvalierday"), result);
        assertTrue(1 == list1.streamCounter.count, "words.stream() should've been called exactly once");
        assertTrue(0 == list1.filterCounter.count, ".filter() should not have been called");
        assertTrue(1 == list1.mapCounter.count, ".map() should've been called exactly once");
        assertTrue(0 == list1.sortedCounter.count, ".sorted() should not have been called");
        assertTrue(0 == list1.otherCounter.count, "Only .map() should've been called");

        var list2 = TestList.of("cartooned", "perambulated", "prerequisite", "monolinguals");
        result = student.pigLatin(list2);
        assertTrue(result == list2.collected, "List returned was not result of .collect()");
        assertEquals(List.of("artoonedcay", "erambulatedpay", "rerequisitepay", "onolingualsmay"), result);
        assertTrue(1 == list2.streamCounter.count, "words.stream() should've been called exactly once");
        assertTrue(0 == list2.filterCounter.count, ".filter() should not have been called");
        assertTrue(1 == list2.mapCounter.count, ".map() should've been called exactly once");
        assertTrue(0 == list2.sortedCounter.count, ".sorted() should not have been called");
        assertTrue(0 == list2.otherCounter.count, "Only .map() should've been called");
    }

    @Test
    @Order(3)
    void sortByLastCharacter() {
        var list1 = TestList.of("zeroing", "chunk's", "hydrophones", "launchpad", "salacity", "pointillism's", "googlies", "circuity", "confiscate", "festivities", "renounces", "expansively");
        var result = student.sortByLastCharacter(list1);

        assertTrue(result == list1.collected, "List returned was not result of .collect()");
        assertEquals(List.of("launchpad", "confiscate", "zeroing", "chunk's", "hydrophones", "pointillism's", "googlies", "festivities", "renounces", "salacity", "circuity", "expansively"), result);
        assertTrue(1 == list1.streamCounter.count, "words.stream() should've been called exactly once");
        assertTrue(0 == list1.filterCounter.count, ".filter() should not have been called");
        assertTrue(0 == list1.mapCounter.count, ".map() should not have been called");
        assertTrue(1 == list1.sortedCounter.count, ".sorted() should've been called exactly once'");
        assertTrue(0 == list1.otherCounter.count, "Only .sorted() should've been called");

        var list2 = TestList.of("Ontario's", "dedicates", "tackle's", "illusions", "Yukon", "Gideon's", "inscribed", "demulcent", "screamers", "garçon's", "Hebrew", "gerrymandering", "lug's", "demanded");
        result = student.sortByLastCharacter(list2);
        assertTrue(result == list2.collected, "List returned was not result of .collect()");
        assertEquals(List.of("inscribed", "demanded", "gerrymandering", "Yukon", "Ontario's", "dedicates", "tackle's", "illusions", "Gideon's", "screamers", "garçon's", "lug's", "demulcent", "Hebrew"), result);
        assertTrue(1 == list2.streamCounter.count, "words.stream() should've been called exactly once");
        assertTrue(0 == list2.filterCounter.count, ".filter() should not have been called");
        assertTrue(0 == list2.mapCounter.count, ".map() should not have been called");
        assertTrue(1 == list2.sortedCounter.count, ".sorted() should've been called exactly once'");
        assertTrue(0 == list2.otherCounter.count, "Only .sorted() should've been called");
    }

    @Test
    @Order(4)
    void transformWords() {
        var list1 = TestList.of("regression", "chattiest", "woodsiest", "imperial", "oversight", "dias", "trilogies", "goings", "lottery", "shufflers");
        var result = student.transformWords(list1);

        assertTrue(result == list1.collected, "List returned was not result of .collect()");
        assertEquals(List.of("iasday"), result);
        assertTrue(1 == list1.streamCounter.count, "words.stream() should've been called exactly once");
        assertTrue(1 == list1.filterCounter.count, ".filter() should've been called exactly once");
        assertTrue(1 == list1.mapCounter.count, ".map() should've been called exactly once");
        assertTrue(1 == list1.sortedCounter.count, ".sorted() should've been called exactly once'");
        assertTrue(0 == list1.otherCounter.count, "Only .filter(), .map(), and .sorted() should've been called");

        var list2 = TestList.of("dingoes", "Beardmore", "cavil", "unsaid", "badminton", "nonage", "butane", "gerund's", "Lithuanians", "adjuring", "subordinates", "hussar's", "Poussin's", "chewing", "improves", "aka", "Thracian's", "plentiful", "scoff", "hasting");
        result = student.transformWords(list2);
        assertTrue(result == list2.collected, "List returned was not result of .collect()");
        assertEquals(List.of("kaaay", "coffsay", "avilcay"), result);
        assertTrue(1 == list2.streamCounter.count, "words.stream() should've been called exactly once");
        assertTrue(1 == list2.filterCounter.count, ".filter() should've been called exactly once");
        assertTrue(1 == list2.mapCounter.count, ".map() should've been called exactly once");
        assertTrue(1 == list2.sortedCounter.count, ".sorted() should've been called exactly once'");
        assertTrue(0 == list2.otherCounter.count, "Only .filter(), .map(), and .sorted() should've been called");
    }

    private static class Counter {
        private int count = 0;

        private void increment() {
            ++count;
        }

        private int value() {
            return count;
        }
    }

    private static class TestList extends ArrayList<String> {

        private final Counter
                streamCounter = new Counter(),
                filterCounter = new Counter(),
                mapCounter = new Counter(),
                sortedCounter = new Counter(),
                otherCounter = new Counter();
        private Object collected = null;

        private TestList(String[] words) {
            super(Arrays.asList(words));
        }

        private static TestList of(String... words) {
            return new TestList(words);
        }

        @Override
        public Stream<String> stream() {
            streamCounter.increment();
            return new TestStream<>(super.stream(), this);
        }

        @Override
        public Stream<String> parallelStream() {
            throw new UnsupportedOperationException();
        }
    }

    private static class TestStream<R> implements Stream<R> {

        private Stream<R> delegate;
        private TestList parentList;
        private Counter filterCounter, mapCounter, sortedCounter, otherCounter;

        private TestStream(Stream<R> delegate,
                           TestList parentList) {
            this.delegate = delegate;
            this.parentList = parentList;

            this.filterCounter = parentList.filterCounter;
            this.mapCounter = parentList.mapCounter;
            this.sortedCounter = parentList.sortedCounter;
            this.otherCounter = parentList.otherCounter;
        }

        private <R1> Stream<R1> wrap(Stream<R1> d) {
            return new TestStream<>(d, parentList);
        }

        @Override
        public Stream<R> filter(Predicate<? super R> predicate) {
            filterCounter.increment();
            return wrap(delegate.filter(predicate));
        }

        @Override
        public <R1> Stream<R1> map(Function<? super R, ? extends R1> mapper) {
            mapCounter.increment();
            return wrap(delegate.map(mapper));
        }

        @Override
        public IntStream mapToInt(ToIntFunction<? super R> mapper) {
            otherCounter.increment();
            return delegate.mapToInt(mapper);
        }

        @Override
        public LongStream mapToLong(ToLongFunction<? super R> mapper) {
            otherCounter.increment();
            return delegate.mapToLong(mapper);
        }

        @Override
        public DoubleStream mapToDouble(ToDoubleFunction<? super R> mapper) {
            otherCounter.increment();
            return delegate.mapToDouble(mapper);
        }

        @Override
        public <R1> Stream<R1> flatMap(Function<? super R, ? extends Stream<? extends R1>> mapper) {
            otherCounter.increment();
            return wrap(delegate.flatMap(mapper));
        }

        @Override
        public IntStream flatMapToInt(Function<? super R, ? extends IntStream> mapper) {
            otherCounter.increment();
            return delegate.flatMapToInt(mapper);
        }

        @Override
        public LongStream flatMapToLong(Function<? super R, ? extends LongStream> mapper) {
            otherCounter.increment();
            return delegate.flatMapToLong(mapper);
        }

        @Override
        public DoubleStream flatMapToDouble(Function<? super R, ? extends DoubleStream> mapper) {
            otherCounter.increment();
            return delegate.flatMapToDouble(mapper);
        }

        @Override
        public Stream<R> distinct() {
            otherCounter.increment();
            return wrap(delegate.distinct());
        }

        @Override
        public Stream<R> sorted() {
            otherCounter.increment();
            return wrap(delegate.sorted());
        }

        @Override
        public Stream<R> sorted(Comparator<? super R> comparator) {
            sortedCounter.increment();
            return wrap(delegate.sorted(comparator));
        }

        @Override
        public Stream<R> peek(Consumer<? super R> action) {
            otherCounter.increment();
            return wrap(delegate.peek(action));
        }

        @Override
        public Stream<R> limit(long maxSize) {
            otherCounter.increment();
            return wrap(delegate.limit(maxSize));
        }

        @Override
        public Stream<R> skip(long n) {
            otherCounter.increment();
            return wrap(delegate.skip(n));
        }

        @Override
        public Stream<R> takeWhile(Predicate<? super R> predicate) {
            otherCounter.increment();
            return wrap(delegate.takeWhile(predicate));
        }

        @Override
        public Stream<R> dropWhile(Predicate<? super R> predicate) {
            otherCounter.increment();
            return wrap(delegate.dropWhile(predicate));
        }

        @Override
        public void forEach(Consumer<? super R> action) {
            otherCounter.increment();
            delegate.forEach(action);
        }

        @Override
        public void forEachOrdered(Consumer<? super R> action) {
            otherCounter.increment();
            delegate.forEachOrdered(action);
        }

        @Override
        public Object[] toArray() {
            otherCounter.increment();
            return delegate.toArray();
        }

        @Override
        public <A> A[] toArray(IntFunction<A[]> generator) {
            otherCounter.increment();
            return delegate.toArray(generator);
        }

        @Override
        public R reduce(R identity, BinaryOperator<R> accumulator) {
            otherCounter.increment();
            return delegate.reduce(identity, accumulator);
        }

        @Override
        public Optional<R> reduce(BinaryOperator<R> accumulator) {
            otherCounter.increment();
            return delegate.reduce(accumulator);
        }

        @Override
        public <U> U reduce(U identity, BiFunction<U, ? super R, U> accumulator, BinaryOperator<U> combiner) {
            otherCounter.increment();
            return delegate.reduce(identity, accumulator, combiner);
        }

        @Override
        public <R1> R1 collect(Supplier<R1> supplier, BiConsumer<R1, ? super R> accumulator, BiConsumer<R1, R1> combiner) {
            otherCounter.increment();
            return delegate.collect(supplier, accumulator, combiner);
        }

        @Override
        public <R1, A> R1 collect(Collector<? super R, A, R1> collector) {
            parentList.collected = delegate.collect(collector);
            return (R1)parentList.collected;
        }

        @Override
        public Optional<R> min(Comparator<? super R> comparator) {
            otherCounter.increment();
            return delegate.min(comparator);
        }

        @Override
        public Optional<R> max(Comparator<? super R> comparator) {
            otherCounter.increment();
            return delegate.max(comparator);
        }

        @Override
        public long count() {
            otherCounter.increment();
            return delegate.count();
        }

        @Override
        public boolean anyMatch(Predicate<? super R> predicate) {
            otherCounter.increment();
            return delegate.anyMatch(predicate);
        }

        @Override
        public boolean allMatch(Predicate<? super R> predicate) {
            otherCounter.increment();
            return delegate.allMatch(predicate);
        }

        @Override
        public boolean noneMatch(Predicate<? super R> predicate) {
            otherCounter.increment();
            return delegate.noneMatch(predicate);
        }

        @Override
        public Optional<R> findFirst() {
            otherCounter.increment();
            return delegate.findFirst();
        }

        @Override
        public Optional<R> findAny() {
            otherCounter.increment();
            return delegate.findAny();
        }

        @Override
        public Iterator<R> iterator() {
            return delegate.iterator();
        }

        @Override
        public Spliterator<R> spliterator() {
            return delegate.spliterator();
        }

        @Override
        public boolean isParallel() {
            return delegate.isParallel();
        }

        @Override
        public Stream<R> sequential() {
            otherCounter.increment();
            return delegate.sequential();
        }

        @Override
        public Stream<R> parallel() {
            otherCounter.increment();
            return delegate.parallel();
        }

        @Override
        public Stream<R> unordered() {
            otherCounter.increment();
            return delegate.unordered();
        }

        @Override
        public Stream<R> onClose(Runnable closeHandler) {
            otherCounter.increment();
            return delegate.onClose(closeHandler);
        }

        @Override
        public void close() {
            delegate.close();
        }
    }
}