package org.talend.interview.backend.phone.inventory;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.talend.interview.backend.phone.inventory.controllers.PhoneController;
import org.talend.interview.backend.phone.inventory.models.Phone;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhoneInventoryApplicationTests {

	@Autowired
	private PhoneController phoneController;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testMapLocalPhoneWithMarket(){
		Phone defaultPhone = new Phone("iPhone 7 Plus", "3", 600);
		Phone updatedPhone = phoneController.mapLocalPhoneWithMarket(defaultPhone);

		Assert.assertNotNull(updatedPhone);
		Assert.assertEquals("les valeurs doivent etre identiques", defaultPhone.getName(), updatedPhone.getName());
		Assert.assertEquals("les valeurs doivent etre identiques", defaultPhone.getBrand(), updatedPhone.getBrand());
		Assert.assertEquals("Le prix doit etre égal à 400", 400, updatedPhone.getOriginalPrice());
	}

}
