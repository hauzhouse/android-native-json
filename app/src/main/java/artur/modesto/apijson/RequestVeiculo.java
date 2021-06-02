package artur.modesto.apijson;

import android.widget.ArrayAdapter;

import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by logonrm on 25/05/2017.
 */
public class RequestVeiculo implements Response.Listener<JSONArray> {
    private ArrayAdapter adpVeiculo;

    public RequestVeiculo(ArrayAdapter<Veiculo> adpVeiculo) {
        this.adpVeiculo = adpVeiculo;
    }

    @Override
    public void onResponse(JSONArray response) {
        for (int i = 0; i < response.length(); i++) {

            try {
                JSONObject obj = response.getJSONObject(i);
                Veiculo v = new Veiculo(obj.getInt("id"), obj.getString("fipe_name"));
                adpVeiculo.add(v);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
