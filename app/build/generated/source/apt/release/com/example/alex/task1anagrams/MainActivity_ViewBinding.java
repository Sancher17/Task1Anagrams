// Generated code from Butter Knife. Do not modify!
package com.example.alex.task1anagrams;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.CharSequence;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131165231;

  private TextWatcher view2131165231TextWatcher;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.textView = Utils.findRequiredViewAsType(source, R.id.textView_output, "field 'textView'", TextView.class);
    view = Utils.findRequiredView(source, R.id.editText_input, "method 'afterTextChanged'");
    view2131165231 = view;
    view2131165231TextWatcher = new TextWatcher() {
      @Override
      public void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
      }

      @Override
      public void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
      }

      @Override
      public void afterTextChanged(Editable p0) {
        target.afterTextChanged(p0);
      }
    };
    ((TextView) view).addTextChangedListener(view2131165231TextWatcher);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textView = null;

    ((TextView) view2131165231).removeTextChangedListener(view2131165231TextWatcher);
    view2131165231TextWatcher = null;
    view2131165231 = null;
  }
}
