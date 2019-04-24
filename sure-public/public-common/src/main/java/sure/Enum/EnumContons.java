package sure.Enum;

public enum EnumContons implements IEnum<String>{
    TRUE("T", "是"),
    FALSE("F", "否");


    public final String key;
    public final String value;

    private EnumContons(String key, String value) {
        this.key = key;
        this.value=value;
    }
    @Override
    public String key() {
        return this.key;
    }

    @Override
    public String value() {
        return this.value;
    }
}
