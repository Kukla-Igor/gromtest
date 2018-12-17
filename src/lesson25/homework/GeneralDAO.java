package lesson25.homework;

public class  GeneralDAO <T extends IdEntity> {

    @SuppressWarnings("unchecked")

    private T[] arr = (T[]) new IdEntity[10];

    public T save(T t) throws Exception {
        if (t == null)
            throw new Exception("input data not set");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && t.getId() == arr[i].getId())
                throw new Exception("so id is already here");
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null)
                return arr[i] = t;
        }
        throw new Exception("unexpected error");

    }


    public T[] getAll() {
        int length = 0;

        for (T el : arr){
            if (el != null)
                length++;
        }

        T[] result = (T[]) new IdEntity[length];
        int index = 0;

        for (T el : arr){
            if (el != null){
                result[index] = el;
                index++;
            }

        }
        return result;


    }
}



