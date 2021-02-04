# Custom Snackbar
Snackbar with custom attributes

Using the library [material.io](https://material.io)

    implementation 'com.google.android.material:material:1.3.0'
    
The purpose of this customization, is to provide more control under the Snackbar, this includes:

- background color,
- card size
- rounding value in the corners
- possibility of adding icons 
- and, mainly, controlling its position on the screen.

Focused for use on tablets

The main part of the code is this:

    private void showSnackbar() {

        LayoutInflater mInflater = LayoutInflater.from(this);

        View rootView = findViewById(android.R.id.content);
        Snackbar snackBar = Snackbar.make(rootView, "Olá Mundo", Snackbar.LENGTH_LONG);

        // Get the Snackbar's layout view
        Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackBar.getView();

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        layout.setLayoutParams(lp);

        layout.setPadding(0, 0, 0, 0);

        snackBar.getView().setBackground(ContextCompat.getDrawable(this, R.drawable.bg_snackbar));

        // Hide the text
        TextView textView = (TextView) layout.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setVisibility(View.INVISIBLE);

        // Inflate our custom view
        View snackView = mInflater.inflate(R.layout.my_snackbar, null);
        layout.addView(snackView);

        snackBar.show();
    }
