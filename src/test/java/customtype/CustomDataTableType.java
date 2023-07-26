package customtype;

import domainobjects.BillingDetails;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class CustomDataTableType {

    @DataTableType
    public BillingDetails billingDetails(Map<String, String> billingDetailsMap) {
        return new BillingDetails(
                billingDetailsMap.get("firstName"),
                billingDetailsMap.get("lastname"),
                billingDetailsMap.get("address_line1"),
                billingDetailsMap.get("city"),
                billingDetailsMap.get("state"),
                billingDetailsMap.get("postalCode"),
                billingDetailsMap.get("email")
        );
    }

}
