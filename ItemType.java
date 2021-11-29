public enum ItemType
{
    HEALING("Health Potion"),
    ATTACK_BOOST("Attack Boost"),
    DEFENSE_BOOST("Defense Boost");

    String value;

    ItemType(String type)
    {
        value = type;
    }
}
