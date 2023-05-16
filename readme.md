<h1>Nested JSON Response Handle and Validation using SPring Boot</h1>

## API Request URL: http://localhost:8088/company
## JSON Structure
<code>
{
  "companyName" : "eee",
  "companyEmailId" : "qaautomation@org.com",
  "companyNumber" : "+353891234121",
  "companyAddress" : "12, HeneryStreet, Dublin, D12PW20",
  "supportedSalaryBanks" : [ "AIB", "BOI", "PSB" ],
  "employee" : {
    "firstName" : "",
    "lastName" : "",
    "age" : 30,
    "salary" : 75000.0,
    "designation" : "Manager",
    "contactNumber" : "+919999988822",
    "emailId" : "abc@test.com"
  }, 
  "contractors" : {
    "firstName" : "John",
    "lastName" : "Mathew",
    "contractFrom" : "Jan-2018",
    "contractTo" : "Aug-2022",
    "contactNumber" : "+919631384422"
  },
  "companyPFDetails" : {
    "pfName" : "eee",
    "pfYear" : 2020,
    "noOfEmployees" : 100
  }
}
</code>

<h1> Method One </h1>
<code>
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new LinkedHashMap<>();
    
        for (ObjectError error : e.getBindingResult().getAllErrors()) {
            String fieldName = null;
            String errorMessage = null;
    
            if (error instanceof FieldError) {
                FieldError fieldError = (FieldError) error;
                fieldName = fieldError.getObjectName() + "." + fieldError.getField();
                errorMessage = fieldError.getDefaultMessage();
            } else {
                fieldName = error.getObjectName();
                errorMessage = error.getDefaultMessage();
            }
    
            errors.put(fieldName, errorMessage);
        }
    
        StringBuilder errorMessageBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : errors.entrySet()) {
            errorMessageBuilder.append(entry.getKey())
                    .append(" = ")
                    .append(entry.getValue())
                    .append("\n");
        }
    
        Map<String, Object> errorResponse= new HashMap<>();

        errorResponse.put("errors", errorMessageBuilder.toString());

        return ResponseEntity.badRequest().body(errorResponse);
    }
</code>

## Response Error After Validate

<code>
{
    "errors": "companyDTO.employee.lastName = Employee last name must requred\ncompanyDTO.employee.firstName = Employee first name must requred\n"
}
</code>

<hr/>
<h1>Method Two</h1>

<code>
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
    
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            String fieldName = fieldError.getField();
            String errorMessage = fieldError.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        }

        Map<String, Object> errorResponse = new HashMap<>();

        errorResponse.put("errors", errors);
    
        return ResponseEntity.badRequest().body(errorResponse);
    }
</code>

## Response Error After Validate

<code>
{
    "errors": {
        "employee.firstName": "Employee first name must requred",
        "employee.lastName": "Employee last name must requred"
    }
}
</code>