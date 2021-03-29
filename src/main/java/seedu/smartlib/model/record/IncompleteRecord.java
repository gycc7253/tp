package seedu.smartlib.model.record;

import seedu.smartlib.commons.core.name.Name;
import seedu.smartlib.model.book.Barcode;

/**
 * Incomplete record (i.e. a record with missing barcode) of a borrowing activity.
 */
public class IncompleteRecord extends Record {

    /**
     * Creates a borrowing record.
     *
     * @param bookName     name of the book that is borrowed.
     * @param readerName   reader who borrowed the book.
     * @param dateBorrowed borrow date of the book.
     */
    public IncompleteRecord(Name bookName, Name readerName, DateBorrowed dateBorrowed) {
        super(bookName, new Barcode(Barcode.TEMP_BARCODE_VALUE), readerName, dateBorrowed);
    }

    /**
     * Creates a returning record.
     *
     * @param bookName     name of the book that is borrowed.
     * @param readerName   reader who borrowed the book.
     * @param dateReturned return date of the book.
     */
    public IncompleteRecord(Name bookName, Name readerName, DateReturned dateReturned) {
        super(bookName, new Barcode(Barcode.TEMP_BARCODE_VALUE), readerName, dateReturned);
    }

    /**
     * Returns the book name associated with this incomplete borrow record.
     *
     * @return the book name associated with this incomplete borrow record.
     */
    public Name getBookName() {
        return this.bookName;
    }

}
