package com.example.uts_nmp
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
class DetailActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val imgFoto=findViewById<ImageView>(R.id.imgDetailFoto)
        val txtNama=findViewById<TextView>(R.id.txtDetailNama)
        val txtNRP=findViewById<TextView>(R.id.txtDetailNRP)
        val spinner=findViewById<Spinner>(R.id.spinnerInfo)
        val txtParagraph=findViewById<TextView>(R.id.txtParagraph)
        val radioGroup=findViewById<RadioGroup>(R.id.radioGroupProgram)
        val btnRequest=findViewById<Button>(R.id.btnRequestFriend)
        val nama=intent.getStringExtra("NAMA")?:""
        val nrp=intent.getStringExtra("NRP")?:""
        val jurusan=intent.getStringExtra("JURUSAN")?:""
        val deskripsi=intent.getStringExtra("DESKRIPSI")?:""
        val foto=intent.getStringExtra("FOTO")?:""
        if(!foto.isNullOrEmpty()){
            val resourceId=resources.getIdentifier(foto.substringBefore("."),"drawable",packageName)
            if(resourceId!=0) imgFoto.setImageResource(resourceId)
            else imgFoto.setImageResource(R.drawable.ic_person_placeholder)
        }
        txtNama.text=nama
        txtNRP.text=nrp
        val options=listOf("About Me","My Course","My Experiences")
        val adapter=ArrayAdapter(this,android.R.layout.simple_spinner_item,options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter=adapter
        spinner.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>,view: android.view.View?,position: Int, id: Long){
                txtParagraph.text=when (options[position]){
                    "About Me" -> "Halo, saya $nama dari jurusan $jurusan."
                    "My Course" -> "Saya sedang mengambil berbagai mata kuliah di $jurusan."
                    "My Experiences" -> deskripsi.ifEmpty { "Belum ada pengalaman yang ditambahkan." }
                    else -> ""
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>){}
        }
        when (jurusan){
            "Teknik Informatika"->radioGroup.check(R.id.radioTI)
            "Sistem Informasi"->radioGroup.check(R.id.radioSI)
            "Desain Komunikasi Visual"->radioGroup.check(R.id.radioDKV)
            "Manajemen Bisnis"->radioGroup.check(R.id.radioMB)
        }
        btnRequest.setOnClickListener{
            FriendManager.totalFriends++
            AlertDialog.Builder(this)
                .setTitle("Request Friend")
                .setMessage("Sukses tambah" + nama + "sebagai friend.\nFriend anda sekarang adalah " + FriendManager.totalFriends + ".")
                .setPositiveButton("OK",null)
                .show()
        }
    }
}