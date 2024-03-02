
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		message_4
	 *	@date 		Thursday 29th of February 2024 12:13:43 PM
	 *	@title 		Page 2
	 *	@author 	
	 *	@keywords 	
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */
	

package com.example.solutionsproject.activities;

    import android.app.Activity;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.ImageView;
    import android.widget.TextView;
    import android.widget.Toast;

    import com.example.solutionsproject.R;

    public class message_4_activity extends Activity {


        private View _bg__message_4_ek2;
        private View _bg__message_4_ek4;
        private ImageView vector;
        private View _bg__group_6_ek1;
        private ImageView message_4__background_mask_;
        private View _bg__mask_group_6_ek1;
        private View _bg__tab_ek1;
        private View _bg__title_ek1;
        private View _bg__tab_ek3;
        private View _bg__frame_22_ek1;
        private View _bg__tab_ek5;
        private View _bg__frame_21_ek1;
        private View _bg__title_ek3;
        private ImageView title__background_;
        private TextView message;
        private ImageView selectied_line;
        private ImageView ellipse_70;
        private View _bg__title_ek5;
        private View _bg__tab_ek7;
        private View _bg__frame_21_ek3;
        private View _bg__title_ek7;
        private ImageView title__background__ek1;
        private TextView notification;
        private TextView no_messages___;
        private View _bg__title_ek9;
        private TextView notifications;
        private View _bg__footer_message_ek1;
        private ImageView footer_message__background_;
        private ImageView union;
        private ImageView search;
        private ImageView home;
        private ImageView course;
        private ImageView message_ek1;
        private ImageView account;

        @Override
        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.message_4);


            _bg__message_4_ek2 = (View) findViewById(R.id._bg__message_4_ek2);
            _bg__message_4_ek4 = (View) findViewById(R.id._bg__message_4_ek4);
            vector = (ImageView) findViewById(R.id.vector);
            _bg__group_6_ek1 = (View) findViewById(R.id._bg__group_6_ek1);
            message_4__background_mask_ = (ImageView) findViewById(R.id.message_4__background_mask_);
            _bg__mask_group_6_ek1 = (View) findViewById(R.id._bg__mask_group_6_ek1);
            _bg__title_ek1 = (View) findViewById(R.id._bg__title_ek1);
            _bg__tab_ek3 = (View) findViewById(R.id._bg__tab_ek3);
            _bg__frame_22_ek1 = (View) findViewById(R.id._bg__frame_22_ek1);
            _bg__tab_ek5 = (View) findViewById(R.id._bg__tab_ek5);
            _bg__frame_21_ek1 = (View) findViewById(R.id._bg__frame_21_ek1);
            _bg__title_ek3 = (View) findViewById(R.id._bg__title_ek3);
            message = (TextView) findViewById(R.id.message);
            selectied_line = (ImageView) findViewById(R.id.selectied_line);
            _bg__title_ek5 = (View) findViewById(R.id._bg__title_ek5);
            _bg__tab_ek7 = (View) findViewById(R.id._bg__tab_ek7);
            _bg__frame_21_ek3 = (View) findViewById(R.id._bg__frame_21_ek3);
            _bg__title_ek7 = (View) findViewById(R.id._bg__title_ek7);
            notification = (TextView) findViewById(R.id.notification);
            no_messages___ = (TextView) findViewById(R.id.no_messages___);
            _bg__title_ek9 = (View) findViewById(R.id._bg__title_ek9);
            notifications = (TextView) findViewById(R.id.notifications);
            _bg__footer_message_ek1 = (View) findViewById(R.id._bg__footer_message_ek1);
            union = (ImageView) findViewById(R.id.union);
            search = (ImageView) findViewById(R.id.search);
            home = (ImageView) findViewById(R.id.home);
            course = (ImageView) findViewById(R.id.course);
            message_ek1 = (ImageView) findViewById(R.id.message_ek1);
            account = (ImageView) findViewById(R.id.account);


            //custom code goes here
            notification.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(message_4_activity.this, message_3_activity.class));
                }
            });

            search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(message_4_activity.this, "search placeholder", Toast.LENGTH_SHORT).show();
                }
            });

            //footer nav
            account.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(message_4_activity.this, account_activity.class));
                }
            });

            course.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(message_4_activity.this, courses_activity.class));
                }
            });

            home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(message_4_activity.this, home_activity.class));
                }
            });
        }
    }
	
	