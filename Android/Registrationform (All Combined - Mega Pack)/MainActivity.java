package com.example.registrationform;
import android.app.DatePickerDialog;
import android.net.Uri;
import android.os.Bundle;
import android.widget.*;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etEmail, etPass, etConfirm, etPhone;
    private Spinner spinnerCountry;
    private RadioGroup rgGender;
    private CheckBox cbTerms;
    private TextView tvDob;
    private Button btnSubmit, btnDatePicker;
    private ImageView ivProfile;
    // 1. Define the Image Picker Launcher
    private final ActivityResultLauncher<String> mGetContent = registerForActivityResult(
            new ActivityResultContracts.GetContent(),
            uri -> {
                if (uri != null) {
                    ivProfile.setImageURI(uri);
                    Toast.makeText(this, "Profile Picture Updated", Toast.LENGTH_SHORT).show();
                }
            });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. Initialize all views
        ivProfile = findViewById(R.id.ivProfile);
        etName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etPass = findViewById(R.id.etPassword);
        etConfirm = findViewById(R.id.etConfirmPassword);
        rgGender = findViewById(R.id.rgGender);
        cbTerms = findViewById(R.id.cbTerms);
        tvDob = findViewById(R.id.tvDob);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnDatePicker = findViewById(R.id.btnDatePicker);
        spinnerCountry = findViewById(R.id.spinnerCountry);
        // 3. Set Image Click Listener to trigger "Upload"
        ivProfile.setOnClickListener(v -> mGetContent.launch("image/*"));
        // 4. Setup Spinner for Countries
        String[] countries = {"India", "USA", "UK", "Canada", "Australia"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,
                countries);
        spinnerCountry.setAdapter(adapter);
        // 5. Date Picker Logic
        btnDatePicker.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            new DatePickerDialog(this, (view, year, month, dayOfMonth) ->
                    tvDob.setText("DOB: " + dayOfMonth + "/" + (month + 1) + "/" + year),
                    c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
        });
        // 6. Submit Logic
        btnSubmit.setOnClickListener(v -> {
            if (!cbTerms.isChecked()) {
                Toast.makeText(this, "Please agree to Terms", Toast.LENGTH_SHORT).show();
                return;
            }
            String password = etPass.getText().toString();
            String confirm = etConfirm.getText().toString();
            if (password.isEmpty()) {
                Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
            } else if (password.equals(confirm)) {
                Toast.makeText(this, "Registration Successful!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            }
        });
    }
}