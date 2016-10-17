package imkn.strategy;


import imkn.strategy.engine.KeyValueCompressedStoreEngine;
import imkn.strategy.engine.KeyValueInMemoryStoreEngine;
import imkn.strategy.engine.KeyValueStoreEngine;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class KeyValueApp {

    private static void printDebugInfo(KeyValueDB db) {

        List<KeyValueStringItem> stringItems = db.listStringItems();
        System.out.println("string size: " + stringItems.size());

        String ids = stringItems.stream().map(KeyValueStringItem::getId).collect(Collectors.joining(", "));
        System.out.println("string ids: " + ids);

        System.out.println();

        List<KeyValueIntArrayItem> intArrayItems = db.listIntArrayItems();
        System.out.println("int array size: " + intArrayItems.size());

        String intArrayIds = intArrayItems.stream().map(KeyValueIntArrayItem::getId).collect(Collectors.joining(", "));
        System.out.println("int ids: " + intArrayIds);

        System.out.println();
    }

    private static KeyValueStoreEngine getStoreEngine(String arg) {

        KeyValueStoreEngine storeEngine;
        switch (arg) {
            case "0":
                storeEngine = new KeyValueInMemoryStoreEngine();
                break;
            case "1":
                storeEngine = new KeyValueCompressedStoreEngine(new KeyValueInMemoryStoreEngine());
                break;
            case "2":
                storeEngine = new KeyValueFSEngine();
                break;
            case "3":
                storeEngine = new KeyValueCompressedStoreEngine(new KeyValueFSEngine());
                break;
            default:
                throw new IllegalArgumentException();
        }
        return storeEngine;
    }

    public static void main(String[] args) {

        KeyValueStoreEngine storeEngine = getStoreEngine(args[0]);

        KeyValueDB db = new KeyValueDBImpl(storeEngine);

        db.add(KeyValueItems.ITEM_1);
        db.add(KeyValueItems.ITEM_2);
        db.add(KeyValueItems.ITEM_3);

        db.add(KeyValueItems.IITEM_1);
        db.add(KeyValueItems.IITEM_2);
        db.add(KeyValueItems.IITEM_3);

        printDebugInfo(db);

        db.removeStringItem("1");
        db.removeIntArrayItem("1");

        printDebugInfo(db);

        KeyValueStringItem stringItem2 = db.getStringItem("2");
        System.out.println(Objects.equals(stringItem2.getText(), KeyValueItems.ITEM_2.getText()));
        System.out.println(stringItem2.getText());

        KeyValueIntArrayItem intArrayItem2 = db.getIntArrayItem("2");
        System.out.println(Arrays.equals(intArrayItem2.getValue(), KeyValueItems.IITEM_2.getValue()));
        System.out.println(Arrays.toString(intArrayItem2.getValue()));
    }

}
