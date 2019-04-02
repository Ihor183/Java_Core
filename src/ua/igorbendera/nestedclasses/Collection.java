package ua.igorbendera.nestedclasses;

public class Collection {
    private static Number[] array;

    public Collection(Number[] array) {
        Collection.array = array;
    }

    public class Forward implements Iterator {
        private int count = 0;

        @Override
        public boolean hasNext() {
            return count < array.length;
        }

        @Override
        public Object next() {
            return array[count++];
        }
    }

    public Forward createForward() {
        return new Forward();
    }

    public class Backward implements Iterator {
        private int count = array.length - 1;

        @Override
        public boolean hasNext() {
            return count >= 0;
        }

        @Override
        public Object next() {
            return array[count--];
        }
    }

    public Backward createBackward() {
        return new Backward();
    }

    public Iterator AnonymousClass() {
        return new Iterator() {
            private int count = array.length - 1;

            @Override
            public boolean hasNext() {
                return count >= 0;
            }

            @Override
            public Object next() {
                return array[count--];
            }
        };
    }

    public Iterator LocalClass() {
        class Local implements Iterator {
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < array.length;
            }

            @Override
            public Object next() {
                return array[count++];
            }
        }

        return new Local();
    }

    static class StaticClass implements Iterator {
        private int count = 0;

        @Override
        public boolean hasNext() {
            return count < array.length;
        }

        @Override
        public Object next() {
            return array[count++];
        }
    }

    public static StaticClass createStaticClass() {
        return new StaticClass();
    }
}
