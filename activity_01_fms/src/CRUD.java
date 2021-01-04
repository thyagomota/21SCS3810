/*
 * CS3810 - Principles of Database Systems - Spring 2021
 * Instructor: Thyago Mota
 * Description: Activity 01 - CRUD interface
 */

public interface CRUD<K, E> {

    void create(final E ref);

    E read(final K key);

    void update(final K key, final E ref);

    void delete(final K key);

}