package imkn.strategy;


import java.util.Random;

public class KeyValueItems {

    private KeyValueItems() {}

    static KeyValueStringItem ITEM_1 = new KeyValueStringItem("1", "In augue risus, cursus sed consequat ut, suscipit eget metus. Nulla in luctus est. " +
            "Nam in mauris in magna tempus euismod nec vitae sapien. Etiam fringilla congue orci, at pharetra sapien commodo vel. " +
            "Sed bibendum accumsan dui et pulvinar. Sed non efficitur sapien. Vestibulum augue ligula, porttitor eget consectetur in, " +
            "bibendum in lorem. Vivamus gravida vel turpis efficitur viverra. Sed aliquam sit amet odio in posuere. " +
            "In risus ipsum, varius vitae sem id, cursus pulvinar velit. Vestibulum dapibus leo non ultrices cursus. " +
            "Vivamus ac porttitor mi, id vestibulum nisl. Quisque volutpat, diam eget maximus fermentum, urna sem viverra justo, " +
            "non tristique diam lorem at orci.");

    static KeyValueStringItem ITEM_2 = new KeyValueStringItem("2", "Pellentesque habitant morbi tristique senectus et netus et malesuada fames " +
            "ac turpis egestas. Mauris sollicitudin purus urna. Pellentesque tellus ante, venenatis at felis a, pellentesque scelerisque arcu. " +
            "Nam commodo libero augue, et semper leo commodo in. Suspendisse sit amet ligula mauris. Aenean congue tellus lorem, " +
            "vitae venenatis purus mollis quis. Praesent pretium turpis sem. Duis accumsan sit amet ipsum et ornare.");

    static KeyValueStringItem ITEM_3 = new KeyValueStringItem("3", "Sed fermentum, neque quis imperdiet dictum, odio ante congue massa, ac blandit tellus justo eu odio. " +
            "Maecenas luctus eros vel enim facilisis condimentum. Pellentesque maximus faucibus velit, at venenatis mauris accumsan rhoncus. " +
            "Praesent ac augue ligula. Integer elementum purus felis, volutpat egestas lorem scelerisque vitae. " +
            "Donec sapien nisl, maximus in velit sed, gravida lacinia ipsum. Sed a erat maximus, pretium lectus id, dignissim odio. " +
            "Aliquam enim neque, venenatis ut est vitae, efficitur venenatis mauris.");

    static KeyValueIntArrayItem IITEM_1 = new KeyValueIntArrayItem("1", new Random().ints(100, 0, 100).toArray());
    static KeyValueIntArrayItem IITEM_2 = new KeyValueIntArrayItem("2", new Random().ints(1000, 0, 1000).toArray());
    static KeyValueIntArrayItem IITEM_3 = new KeyValueIntArrayItem("3", new Random().ints(10000, 0, 10000).toArray());

}
