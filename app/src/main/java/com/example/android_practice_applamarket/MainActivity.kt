package com.example.android_practice_applamarket

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice_applamarket.data.Product
import com.example.android_practice_applamarket.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ProductAdapter.ViewHolder.OnItemClickListener,ProductAdapter.ViewHolder.OnItemLongClickListener {

    private val itemList = ArrayList<Product>()
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addData()
        initView()
    }

    private lateinit var productAdapter: ProductAdapter
    private fun initView() {
        //RecyclerView
        productAdapter = ProductAdapter(this, this,itemList)
        binding.mainRecyclerView.adapter = productAdapter
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.mainAlarmIcon.setOnClickListener {
            notification()
        }

        binding.mainRecyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!binding.mainRecyclerView.canScrollVertically(-1)
                    && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    binding.floatingButton.visibility = View.GONE
                } else {
                        binding.floatingButton.visibility = View.VISIBLE
                }
            }
        })

        binding.floatingButton.setOnClickListener {
            binding.mainRecyclerView.smoothScrollToPosition(0)
        }
    }

    //리스트에 데이터 추가
    private fun addData() {
        itemList.add(
            Product(R.drawable.sample1, "산지 한달 된 선풍기 팝니다",
                "이사가서 필요가 없어졌어요 급하게 내놓습니다",
                "대현동", 1000, "서울 서대문구 창천동", 13,25)
        )
        itemList.add(
            Product(R.drawable.sample2, "김치냉장고",
                "이사로인해 내놔요",
                "안마담", 20000, "인천 계양구 귤현동", 8,28)
        )
        itemList.add(
            Product(R.drawable.sample3, "샤넬 카드지갑",
                "고퀄지갑이구요\n사용감이 있어서 싸게 내어둡니다",
                "코코유", 10000, "수성구 범어동", 23,5)
        )
        itemList.add(
            Product(R.drawable.sample4, "금고",
                "금고\n떼서 가져가야함\n대우월드마크센텀\n미국이주관계로 싸게 팝니다",
                "Nicole", 10000, "해운대구 우제2동", 14,17)
        )
        itemList.add(
            Product(R.drawable.sample5, "갤럭시Z플립3 팝니다",
                "갤럭시 Z플립3 그린 팝니다\n항시 케이스 씌워서 썻고 필름 한장챙겨드립니다\n화면에 살짝 스크래치난거 말고 크게 이상은없습니다!",
                "절명", 150000, "연제구 연산제8동", 22,9)
        )
        itemList.add(
            Product(R.drawable.sample6, "프라다 복조리백",
                "까임 오염없고 상태 깨끗합니다\n정품여부모름",
                "미니멀하게", 50000, "수원시 영통구 원천동", 25,16)
        )
        itemList.add(
            Product(R.drawable.sample7, "울산 동해오션뷰 60평 복층 펜트하우스 1일 숙박권 펜션 힐링 숙소 별장",
                "울산 동해바다뷰 60평 복층 펜트하우스 1일 숙박권" +
                        "\n(에어컨이 없기에 낮은 가격으로 변경했으며 8월 초 가장 더운날 다녀가신 분 경우 시원했다고 잘 지내다 가셨습니다)" +
                        "\n1. 인원: 6명 기준입니다. 1인 10,000원 추가요금\n2. 장소: 북구 블루마시티, 32-33층" +
                        "\n3. 취사도구, 침구류, 세면도구, 드라이기 2개, 선풍기 4대 구비" +
                        "\n4. 예약방법: 예약금 50,000원 하시면 저희는 명함을 드리며 입실 오전 잔금 입금하시면 저희는 동.호수를 알려드리며 고객님은 예약자분 신분증 앞면 주민번호 뒷자리 가리시거나 지우시고 문자로 보내주시면 저희는 카드키를 우편함에 놓아 둡니다." +
                        "\n5. 33층 옥상 야외 테라스 있음, 가스버너 있음\n6. 고기 굽기 가능\n7. 입실 오후 3시, 오전 11시 퇴실, 정리, 정돈 , 밸브 잠금 부탁드립니다." +
                        "\n8. 층간소음 주의 부탁드립니다.\n9. 방3개, 화장실3개, 비데 3개\n10. 저희 집안이 쓰는 별장입니다."
                , "굿리치", 150000, "남구 옥동", 142,54)
        )
        itemList.add(
            Product(R.drawable.sample8, "샤넬 탑핸들 가방",
                "샤넬 트랜디 CC 탑핸들 스몰 램스킨 블랙 금장 플랩백 !\n색상 : 블랙\n사이즈 : 25.5cm * 17.5cm * 8cm\n" +
                        "구성 : 본품더스트\n급하게 돈이 필요해서 팝니다 ㅠㅠ",
                "난쉽", 180000, "동래구 온천제2동", 31,7)
        )
        itemList.add(
            Product(R.drawable.sample9, "4행정 엔진분무기 판매합니다.",
                "3년전에 사서 한번 사용하고 그대로 둔 상태입니다. 요즘 사용은 안해봤습니다. 그래서 저렴하게 내 놓습니다. 중고라 반품은 어렵습니다.\n",
                "알뜰한", 30000, "원주시 명륜2동", 7,28)
        )
        itemList.add(
            Product(R.drawable.sample10, "셀린느 버킷 가방",
                "22년 신세계 대전 구매입니당\n셀린느 버킷백\n구매해서 몇번사용했어요\n까짐 스크래치 없습니다.\n타지역에서 보내는거라 택배로 진행합니당!",
                "똑태현", 190000, "중구 동화동", 40,6)
        )
    }

    //뒤로가기 버튼 클릭 시
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        var builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.finish_dialog_title)
        builder.setMessage(R.string.finish_dialog_message)

        val listener = DialogInterface.OnClickListener { _, p1 ->
            when(p1) {
                DialogInterface.BUTTON_POSITIVE ->
                    finish()
            }
        }
        builder.setPositiveButton(R.string.finish_dialog_positive_button, listener)
        builder.setNegativeButton(R.string.finish_dialog_negative_button,listener)

        builder.show()

    }

    //알림 기능
    private fun notification() {
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        val builder: NotificationCompat.Builder
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channelId="one-channel"
            val channelName="My Channel One"
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "My Channel One Description"
                setShowBadge(true)
                enableVibration(true)
            }
            manager.createNotificationChannel(channel)

            builder = NotificationCompat.Builder(this, channelId)

        }else {
            builder = NotificationCompat.Builder(this)
        }
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
        builder.run {
            setSmallIcon(R.mipmap.ic_launcher)
            setWhen(System.currentTimeMillis())
            setContentTitle("Apple Market")
            setContentText("Apple Market에서 알려드립니다.")
            addAction(R.mipmap.ic_launcher, "Action", pendingIntent)
        }
        manager.notify(11, builder.build())
    }

    //RecyclerView 아이템 클릭
    override fun onItemClick(product: Product) {
        val intent = Intent(this, DetailContentActivity::class.java)
        intent.putExtra("product", product)
        startActivity(intent)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onItemLongClick(product: Product, position: Int) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("게시글 삭제")
        builder.setMessage("해당 내용을 삭제 하시겠습니까?")

        val listener = DialogInterface.OnClickListener { _, p1 ->
            when (p1) {
                DialogInterface.BUTTON_POSITIVE -> {
                    itemList.removeAt(position)
                    productAdapter.notifyDataSetChanged()
                }
            }
        }
        builder.setPositiveButton("확인", listener)
        builder.setNegativeButton("취소", null)

        builder.show()
    }


}
