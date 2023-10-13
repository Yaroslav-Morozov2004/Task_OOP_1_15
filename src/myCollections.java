import java.util.*;

public class myCollections extends Object{
    private myCollections() {
    }


    public static final List Empty_List = new EmptyList<>();

    public static final <T> List<T> EmptyList(){
        List<T> emptyList = Empty_List;
        return emptyList;
    }

    private static class EmptyList<E>
            extends AbstractList<E>
    {

        public int size() {return 0;}

        public boolean add(E e)  {throw new UnsupportedOperationException(); }

        public E get (int index) {throw new IndexOutOfBoundsException();}

        public void clear(){};

        public boolean isEmpty() {return true;}

        public boolean contains (Object obj) {return false;}

        public <T> T[] toArray(T[] arr){
            arr[0] = null;
            return arr;
        }
        public E remove (int index) {throw new UnsupportedOperationException();}



    }


    //singleTon реализовывается так, что просто в список добавляется какой-то один элемент,
    // а не список, содержащий один элемент переделывается в singleTon список.
    public static <T> List<T> singletonList(T obj){return new SingletonList<>(obj);}

    private static class SingletonList<E>
            extends AbstractList<E> {
        private final E element;
        SingletonList(E object) {element = object;}

        public int size() {return 1;}

        public  E get (int index) {
            if (index != 0){
                throw new UnsupportedOperationException();
            }
            return (element);
        }
        public boolean contains (Object obj){
            if (obj == element){
                return true;
            }
            else return false;
        }
    }


    public static <T> List<T> readonly(List<? extends T> list) {
        return new readonlyList<>(list);
    }

    static class readonlyList<E>
            implements List<E>{


        private final List<? extends E> list;

        readonlyList(List<? extends E > list){

            this.list = list;
        }



        public int size() {
            return list.size();
        }


        public boolean isEmpty() {
            if (list.isEmpty()){
                return true ;
            }
            return false ;
        }

        @Override
        public boolean contains(Object o) {
            throw  new UnsupportedOperationException();
        }

        @Override
        public Iterator<E> iterator() {
            return null;
        }


        public Object[] toArray() {
            return list.toArray();
        }


        public <T> T[] toArray(T[] a) {
            return (T[]) list.toArray();
        }


        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }


        public boolean remove(Object o) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }


        public boolean addAll(Collection<? extends E> c) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(int index, Collection<? extends E> c) {
            return false;
        }


        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }


        public void clear() {
            throw new UnsupportedOperationException();

        }


        public E get(int index) {
            return list.get(index);
        }


        public E set(int index, E element) {
            throw new UnsupportedOperationException();
        }


        public void add(int index, E element) {
            throw new UnsupportedOperationException();
        }


        public E remove(int index) {
            throw new UnsupportedOperationException();
        }

        public int indexOf(Object o) {
            return list.indexOf(o);
        }


        public int lastIndexOf(Object o) {
            return list.lastIndexOf(o);
        }

        @Override
        public ListIterator<E> listIterator() {
            return null;
        }

        @Override
        public ListIterator<E> listIterator(int index) {
            return null;
        }

        @Override
        public List<E> subList(int fromIndex, int toIndex) {
            return null;
        }
    }



    public static <T> List<T> writeonly(List<? extends T> list) {
        return (List<T>) new writeonlyList<>(list);
    }

    static class writeonlyList<E>
            implements List<E> {
        private final List< E> list;

        writeonlyList(List< E> list) {

            this.list = list;
        }



        public int size() {
            return list.size();
        }


        public boolean isEmpty() {
            if(list.isEmpty()) {
                return true;
            }
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<E> iterator() {
            return null;
        }


        public Object[] toArray() {
            return list.toArray();
        }


        public <T> T[] toArray(T[] a) {
            return (T[]) list.toArray();
        }


        public boolean add(E e) {
            return list.add(e);
        }

        @Override
        public boolean remove(Object o) {
            throw  new UnsupportedOperationException();
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            throw  new UnsupportedOperationException();
        }


        public boolean addAll(Collection<? extends E> c) {
            return list.addAll(c);
        }


        public boolean addAll(int index, Collection<? extends E> c) {
            return list.addAll(index, c);
        }


        public boolean removeAll(Collection<?> c) {
            throw  new UnsupportedOperationException();
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }


        public void clear() {
            list.clear();

        }

        @Override
        public E get(int index) {
            return null;
        }


        public E set(int index, E element) {
            return list.set(index,element);
        }


        public void add(int index, E element) {
            list.add(index, element);

        }

        @Override
        public E remove(int index) {
            throw  new UnsupportedOperationException();
        }

        @Override
        public int indexOf(Object o) {
            throw  new UnsupportedOperationException();
        }

        @Override
        public int lastIndexOf(Object o) {
            throw  new UnsupportedOperationException();
        }

        @Override
        public ListIterator<E> listIterator() {
            return null;
        }

        @Override
        public ListIterator<E> listIterator(int index) {
            return null;
        }

        @Override
        public List<E> subList(int fromIndex, int toIndex) {
            return null;
        }
    }


}