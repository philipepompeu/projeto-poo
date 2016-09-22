package VIEW;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;

/**
 *
 * @author philipe.pompeu
 */
public class MyComboBoxEditor extends DefaultCellEditor{
    public MyComboBoxEditor(String[] items) {
        super(new JComboBox(items));
    }
}
