package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Book item1 = new Book(1, "Баязет", 200, "В. Пикуль");
    Book item2 = new Book(2, "Евгений Онегин", 400, "А. С. Пушкин");
    Book item3 = new Book(3, "100 миниатюр", 500, "М. Жванецкий");
    Book item4 = new Book(4, "Airport", 690, "Arthur Hailey");
    Smartphone item5 = new Smartphone(5, "Galaxy S20", 35000, "Samsung");
    Smartphone item6 = new Smartphone(6, "Mi10", 24000, "Xiaomi");
    Smartphone item7 = new Smartphone(7, "7A", 5600, "Honor");
    Smartphone item8 = new Smartphone(8, "Y7", 10300, "Huawei");


    @BeforeEach
    void manageAdd() {
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);
        repository.save(item5);
        repository.save(item6);
        repository.save(item7);
        repository.save(item8);
    }


    @Test
    void searchByBookName() {
        Product[] expected = new Product[]{item4};
        Product[] actual = manager.searchBy("Airport");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByBookAuthor() {
        Product[] expected = new Product[]{item2};
        Product[] actual = manager.searchBy("А. С. Пушкин");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByBookNotValidAuthor() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Толстой");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneName() {
        Product[] expected = new Product[]{item8};
        Product[] actual = manager.searchBy("Y7");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneManufacturer() {
        Product[] expected = new Product[]{item5};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneNotValidManufacturer() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Sony");
        assertArrayEquals(expected, actual);
    }

}