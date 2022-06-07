package A4.G2.service.account;

import A4.G2.model.users.ShippingDetails;
import A4.G2.model.users.User;

public class ShippingDetailsManager implements IShippingDetailsManager {

    @Override
    public String getShippingAddress(User user) {
        return user.getShippingDetails().getAddress();
    }

    @Override
    public String getShippingPreferences(User user) {
        return user.getShippingDetails().getPreferences();
    }

    @Override
    public void modifyShippingAddress(User user, String newAddress) {
        if (user.getShippingDetails() == null) {
            user.setShippingDetails(new ShippingDetails(newAddress, ""));
        } else {
            user.getShippingDetails().setAddress(newAddress);
        }
    }

    @Override
    public void modifyShippingPreferences(User user, String newPreferences) {
        if (user.getShippingDetails() == null) {
            user.setShippingDetails(new ShippingDetails("", newPreferences));
        } else {
            user.getShippingDetails().setPreferences(newPreferences);
        }
    }
}
