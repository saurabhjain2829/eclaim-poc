package com.nagarro.eclaim.constants;

public interface Constants {

    int SUCCESS_CODE = 0;
    int ERROR_CODE = 100;
    String UP = "UP";
    String DOWN = "DOWN";

    String SIMULTANEOUS_UPDATE_MSG = "The record has been updated by another user. Could not complete the action. Please try again.";
    String INTERNAL_SERVER_ERROR = "Internal error occurred while executing request. Please contact an administrator";
    String NOT_RECORD_FOUND_FOR_CRITERIA_MSG = "No Recrod found for given inputs {0}";
    String POLICY_NOT_FOUND="Policy details not found";
	String ACCOUNT_CREATED_SUCESSFULLY = "account created scuccessfuly";
	String INVALID_POLICY_DETAILS = "Invalid policy details";
}
