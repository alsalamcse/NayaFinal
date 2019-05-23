public class Songs1
{
    private String name;
    private String singer;
    private String date;
    private int watchers;
    private long _id;

    public Songs1()//لكل الصفات(اذا زدنا صفة تزاد تلقائيا)
    {

    }
    public Songs1(String name, String singer, String date, int watchers)//بدون id
    {
        this.name=name;
        this.singer=singer;
        this.date=date;
    }

    public Songs1(int id, String name, String singer, String date, int watchers)//مع id
    {
        this._id=id;
        this.name=name;
        this.singer=singer;
        this.date=date;
        this.watchers=watchers;
    }
    public String getName()
    {
        return name;
    }

    public String getSinger() {
        return singer;
    }

    public String getDate() {
        return date;
    }

    public int getWatchers() {
        return watchers;
    }

    public long get_id() {
        return _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSinger(String singer) {

        this.singer = singer;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setWatchers(int watchers) {
        this.watchers = watchers;
    }
    public String toString() {
        return "name:"+name+"siger:"+singer+"date:"+date+"watchers:"+watchers+"_id:"+_id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }
}
