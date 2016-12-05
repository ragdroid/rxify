package com.ragdroid.rxify.logic.data.remote;

import android.support.annotation.NonNull;

import com.ragdroid.rxify.core.data.BookDataSource;
import com.ragdroid.rxify.entity.Book;
import com.ragdroid.rxify.logic.random.Randomizer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/**
 * Simulates network call by adding latency
 * Book list from http://harrypotter.wikia.com/wiki/List_of_books - gotta teach myself scraping someday
 * Wish there was some API I could hit
 * Created by garimajain on 05/11/16.
 */
public class BookRemoteDataSource implements BookDataSource {

    private final Randomizer randomizer;
    private List<Book> bookList;

    @Inject
    public BookRemoteDataSource(Randomizer randomizer) {
        this.randomizer = randomizer;
    }

    /**
     * I am not so proud of this way of initializing books but WTH
     */
    private void initBooksDB() {
        bookList = new ArrayList<>();
        addBook("Famous Fire-Eaters");
        addBook("Fifteenth-Century Fiends");
        addBook("Magick Moste Evile");
        addBook("Shrieking book");
        addBook("Book of Spells");
        addBook("Break with a Banshee");
        addBook("Confronting the Faceless");
        addBook("The Dark Forces: A Guide to Self-Protection");
        addBook("Defensive Magical Theory");
        addBook("The Essential Defence Against the Dark Arts");
        addBook("Gadding with Ghouls");
        addBook("Holidays with Hags");
        addBook("Travels with Trolls");
        addBook("Voyages with Vampires");
        addBook("Wanderings with Werewolves");
        addBook("Year with the Yeti");
        addBook("The Dream Oracle");
        addBook("Unfogging the Future");
        addBook("A Beginner's Guide to Transfiguration");
        addBook("A Guide to Advanced Transfiguration");
        addBook("Intermediate Transfiguration");
        addBook("Advanced Potion-Making");
        addBook("Magical Draughts and Potions");
        addBook("Home Life and Social Habits of British Muggles");
        addBook("A History of Magic");
        addBook("One Thousand Magical Herbs and Fungi");
        addBook("Ingredient Encyclopedia");
        addBook("Flesh-Eating Trees of the World");
        addBook("The Standard Book of Spells");
        addBook("Quintessence: A Quest");
        addBook("Fantastic Beasts and Where to Find Them");
        addBook("The Monster Book of Monsters");
        addBook("Numerology and Grammatica");
        addBook("Handbook of Do-It-Yourself Broomcare");
        addBook("Beating the Bludgers - A Study of Defensive Strategies in Quidditch");
        addBook("Flying with the Cannons");
        addBook("The Noble Sport of Warlocks");
        addBook("The Official Guide to the Quidditch World Cup");
        addBook("Quidditch Through the Ages");
        addBook("Quidditch Teams of Britain and Ireland");
        addBook("The Wonder of Wigtown Wanderers");
        addBook("Muggle 'Law & Order' - Complete Guide");
        addBook("Unforgivable Curses and their Legal Implications");
        addBook("Magical Moral Perspective");
        addBook("Magical Misdemeanours in the Modern Law");
        addBook("Legislative Guide to the Proper Use of Magic");
        addBook("Legal Guidelines for the Manufacture of Magical Apparatus");
        addBook("Laws of Conduct When Dealing With Muggles");
        addBook("Legal Rules for Roving Sprites");
        addBook("Legal Loopholes & Leprechauns");
        addBook("Law and Literature");
        addBook("Illegal Compendium 198");
        addBook("Guidelines for the Treatment of Non-Wizard Part-Humans");
        addBook("Extraordinary Trials in History");
        addBook("The Intricacies of Rappaport's Law");
        addBook("The Dark Arts — A Legal Compendium");
        addBook("The Dark Arts: A Legal Companion");
        addBook("Ancient Law");
        addBook("Famous Fire-Eaters");
        addBook("Great Wizards of the Twentieth Century");
        addBook("Nature's Nobility: A Wizarding Genealogy");
        addBook("Notable Magical Names of Our Time");
        addBook("The Rise and Fall of the Dark Arts");
        addBook("Prefects Who Gained Power");
        addBook("An Anthology of Eighteenth Century Charms");
        addBook("A Guide to Medieval Sorcery");
        addBook("Snape: Scoundrel or Saint?");
        addBook("Biography of Harry Potter");
        addBook("My Life as a Squib");
        addBook("My Life as a Muggle");
        addBook("Magical Me");
        addBook("The Life and Lies of Albus Dumbledore");
        addBook("He Flew Like a Madman");
        addBook("Dumbledore’s Army: The Dark Side of the Demob");
        addBook("Biography of Uric the Oddball");
        addBook("Armando Dippet: Master or Moron?");
        addBook("Cram It!: How to Soar on Your O.W.L.s");
        addBook("W.O.M.B.A.T. Revision Guide");
        addBook("Asiatic Anti-Venoms");
        addBook("Easy Spells to Fool Muggles");
        addBook("Gilded-covered spellbook");
        addBook("Jiggery Pokery and Hocus Pocus");
        addBook("My Favourite Spells");
        addBook("Wizards' Book");
        addBook("Unidentified spellbook");
        addBook("Wizard's Spells");

    }


    private Book addBook(String bookName) {
        Book book = new Book(bookName);
        bookList.add(book);
        return book;
    }


    @Override
    public Observable<List<Book>> getBook(@NonNull final String query) {
        //more the length, lesser the delay
        int start = 3000 / query.length();
        //wanted to perform `initBooks()` in background as well
        return Observable.fromCallable(new Callable<List<Book>>() {
            @Override
            public List<Book> call() throws Exception {
                if (bookList == null) {
                    initBooksDB();
                }
                return bookList;
            }
        }).flatMap(new Function<List<Book>, ObservableSource<Book>>() {
            @Override
            public ObservableSource<Book> apply(List<Book> books) throws Exception {
                return Observable.fromIterable(books);
            }
        }).filter(new Predicate<Book>() {
            @Override
            public boolean test(Book book) throws Exception {
                return book.name.contains(query);
            }
        }).toList()
                .toObservable()
                .delay(randomizer.randomInRange(start, start + 100), TimeUnit.MILLISECONDS);
    }
}
