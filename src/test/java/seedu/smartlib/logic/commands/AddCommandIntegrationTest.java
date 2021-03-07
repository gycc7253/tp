package seedu.smartlib.logic.commands;

import static seedu.smartlib.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.smartlib.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.smartlib.testutil.TypicalReaders.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.smartlib.model.Model;
import seedu.smartlib.model.ModelManager;
import seedu.smartlib.model.UserPrefs;
import seedu.smartlib.model.reader.Reader;
import seedu.smartlib.testutil.ReaderBuilder;

/**
 * Contains integration tests (interaction with the Model) for {@code AddCommand}.
 */
public class AddCommandIntegrationTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_newReader_success() {
        Reader validReader = new ReaderBuilder().build();

        Model expectedModel = new ModelManager(model.getSmartLib(), new UserPrefs());
        expectedModel.addReader(validReader);

        assertCommandSuccess(new AddReaderCommand(validReader), model,
                String.format(AddReaderCommand.MESSAGE_SUCCESS, validReader), expectedModel);
    }

    @Test
    public void execute_duplicatePerson_throwsCommandException() {
        Reader readerInList = model.getSmartLib().getPersonList().get(0);
        assertCommandFailure(new AddReaderCommand(readerInList), model, AddReaderCommand.MESSAGE_DUPLICATE_READER);
    }

}
