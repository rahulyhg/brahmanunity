package com.brahmanunity.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.brahmanunity.model.AddressDetailsModel;
import com.brahmanunity.model.MatrimonyLogin;
import com.brahmanunity.model.PersonalDetailsModel;
import com.brahmanunity.pojo.AddressTakenDto;
import com.brahmanunity.pojo.PersonalDetailsDTO;
import com.brahmanunity.pojo.ProfileAddressDto;

public class ObjectConvertor {

	public static MatrimonyLogin convertLoginDetails(com.brahmanunity.pojo.LoginDetailsDto loginPojo) {
		MatrimonyLogin loginDetailsModel = new MatrimonyLogin();
		loginDetailsModel.setUser_name(loginPojo.getUser_name());
		loginDetailsModel.setPassword(loginPojo.getPassword());
		return loginDetailsModel;
	}

	public static PersonalDetailsModel convertPersonalDetails(PersonalDetailsDTO personalDetailsDto) {
        PersonalDetailsModel personalDetails = new PersonalDetailsModel();
        if(personalDetailsDto.getId() != 0) {
        	personalDetails.setId(personalDetailsDto.getId());
        }
        try {
        	SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
            Date dateTime = formatter.parse(personalDetailsDto.getBirthDate());
    		personalDetails.setBirthDate(dateTime);
        }  catch (ParseException e) {
            e.printStackTrace();
        }
        personalDetails.setAboutMe(personalDetailsDto.getAboutMe());
        personalDetails.setBirthPlace(personalDetailsDto.getBirthPlace());
        personalDetails.setBirthTime(personalDetailsDto.getBirthTime());
        personalDetails.setFirstName(personalDetailsDto.getFirstName());
        personalDetails.setGender(personalDetailsDto.getGender());
        personalDetails.setMotherTongue(personalDetailsDto.getMotherTongue());
        personalDetails.setMiddleName(personalDetailsDto.getMiddleName());
        personalDetails.setLastName(personalDetailsDto.getLastName());
        personalDetails.setHobbies(personalDetailsDto.getHobbies());
        personalDetails.setMailId(personalDetailsDto.getMailId());
        personalDetails.setMaritalStatus(personalDetailsDto.getMaritalStatus());
        personalDetails.setRegisterBy(personalDetailsDto.getRegisterBy());
        personalDetails.setReligion(personalDetailsDto.getReligion());
        
		return personalDetails;
	}
	
	public static PersonalDetailsDTO convertPersonalDetailsDTO(PersonalDetailsModel personalDetailsDto) {
        PersonalDetailsDTO personalDetails = new PersonalDetailsDTO();
        if(personalDetailsDto.getId() != 0) {
        	personalDetails.setId(personalDetailsDto.getId());
        }
        try {
        	SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
			String format = formatter.format(personalDetailsDto.getBirthDate().getTime());
			personalDetails.setBirthDate(format);
        }  catch (Exception e) {
            e.printStackTrace();
        }
        personalDetails.setAboutMe(personalDetailsDto.getAboutMe());
        personalDetails.setBirthPlace(personalDetailsDto.getBirthPlace());
        personalDetails.setBirthTime(personalDetailsDto.getBirthTime());
        personalDetails.setFirstName(personalDetailsDto.getFirstName());
        personalDetails.setGender(personalDetailsDto.getGender());
        personalDetails.setMotherTongue(personalDetailsDto.getMotherTongue());
        personalDetails.setMiddleName(personalDetailsDto.getMiddleName());
        personalDetails.setLastName(personalDetailsDto.getLastName());
        personalDetails.setHobbies(personalDetailsDto.getHobbies());
        personalDetails.setMailId(personalDetailsDto.getMailId());
        personalDetails.setMaritalStatus(personalDetailsDto.getMaritalStatus());
        personalDetails.setRegisterBy(personalDetailsDto.getRegisterBy());
        personalDetails.setReligion(personalDetailsDto.getReligion());
        
		return personalDetails;
	}

	public static ProfileAddressDto convertAddressModelToAddress(List<AddressDetailsModel> alladdressDetails, boolean b) {
		ProfileAddressDto profileAddress = new ProfileAddressDto();
		List<AddressTakenDto> addressList = new ArrayList<AddressTakenDto>();
		alladdressDetails.forEach(item -> {
			AddressTakenDto address = new AddressTakenDto();
			address.setAddress(item.getAddress());
			address.setContact(item.getContact());
			address.setAlternateNumber(item.getAlternateNumber());
			address.setCandidateId(item.getCandidateId());
			addressList.add(address);
		});
		profileAddress.setAddressExist(b);
		profileAddress.setAllAddress(addressList);
		return profileAddress;
	}

}
