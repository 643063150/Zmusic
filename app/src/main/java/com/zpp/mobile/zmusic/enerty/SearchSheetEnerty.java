package com.zpp.mobile.zmusic.enerty;

import java.util.List;

/**
 * @ProjectName: Zmusic
 * @Package: com.zpp.mobile.zmusic.enerty
 * @ClassName: SearchSheetEnerty
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/21 13:35
 * @UpdateUser:
 * @UpdateDate: 2023/3/21 13:35
 * @UpdateRemark:
 */
public class SearchSheetEnerty {

    /**
     * result : {"searchQcReminder":null,"playlists":[{"id":962437258,"name":"海阔天空【Beyond】","coverImgUrl":"https://p1.music.126.net/4-pcFf-ZogAjRpr-Z0GSnw==/109951163045433017.jpg","creator":{"nickname":"大海_1995","userId":322006025,"userType":0,"avatarUrl":null,"authStatus":0,"expertTags":null,"experts":null},"subscribed":false,"trackCount":19,"userId":322006025,"playCount":1356453,"bookCount":15636,"specialType":0,"officialTags":null,"action":null,"actionType":null,"recommendText":null,"score":null,"description":"对于一位朋友所说的创建者用没用心我想我没必要争辩些什么，因为这本就是我的无心之举。本人07年初中受一位热爱摇滚的同学影响开始听beyond，初听只是感觉节奏很好，后来慢慢了解到歌词之后才发现都是人生真理。在人生不同时候，家驹的歌真的能听出不同的感悟，有那么几个瞬间，我感觉我跟家驹有了共鸣。而创建这个歌单，也只是把能让我听过之后有所感悟的歌曲收藏起来。刚开始真没想到会有这么多人收藏，所以这个歌单还一直是最初收藏的那些经典歌曲，最后也希望越来越多人喜欢家驹，并且听完家驹的歌之后都能有所感悟，仅此而已。 \n只要大家没有忘记，家驹就一直不会死去。","highQuality":false},{"id":7626695300,"name":"经典粤语|不是老歌好听了，而是都有故事了","coverImgUrl":"https://p1.music.126.net/z0D6IZ67JrwLsWlFMScl6Q==/109951167853795911.jpg","creator":{"nickname":"本该先生","userId":41142946,"userType":207,"avatarUrl":null,"authStatus":0,"expertTags":null,"experts":{"1":"泛生活视频达人","2":"生活图文达人"}},"subscribed":false,"trackCount":143,"userId":41142946,"playCount":1087349,"bookCount":5948,"specialType":0,"officialTags":null,"action":null,"actionType":null,"recommendText":null,"score":null,"description":"世界小的像一条街的布景 ，我们相遇了 ，你点点头 ，省略了所有的往事 省略了问候。","highQuality":false}],"playlistCount":282}
     * code : 200
     */

    private ResultBean result;
    private int code;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class ResultBean {
        /**
         * searchQcReminder : null
         * playlists : [{"id":962437258,"name":"海阔天空【Beyond】","coverImgUrl":"https://p1.music.126.net/4-pcFf-ZogAjRpr-Z0GSnw==/109951163045433017.jpg","creator":{"nickname":"大海_1995","userId":322006025,"userType":0,"avatarUrl":null,"authStatus":0,"expertTags":null,"experts":null},"subscribed":false,"trackCount":19,"userId":322006025,"playCount":1356453,"bookCount":15636,"specialType":0,"officialTags":null,"action":null,"actionType":null,"recommendText":null,"score":null,"description":"对于一位朋友所说的创建者用没用心我想我没必要争辩些什么，因为这本就是我的无心之举。本人07年初中受一位热爱摇滚的同学影响开始听beyond，初听只是感觉节奏很好，后来慢慢了解到歌词之后才发现都是人生真理。在人生不同时候，家驹的歌真的能听出不同的感悟，有那么几个瞬间，我感觉我跟家驹有了共鸣。而创建这个歌单，也只是把能让我听过之后有所感悟的歌曲收藏起来。刚开始真没想到会有这么多人收藏，所以这个歌单还一直是最初收藏的那些经典歌曲，最后也希望越来越多人喜欢家驹，并且听完家驹的歌之后都能有所感悟，仅此而已。 \n只要大家没有忘记，家驹就一直不会死去。","highQuality":false},{"id":7626695300,"name":"经典粤语|不是老歌好听了，而是都有故事了","coverImgUrl":"https://p1.music.126.net/z0D6IZ67JrwLsWlFMScl6Q==/109951167853795911.jpg","creator":{"nickname":"本该先生","userId":41142946,"userType":207,"avatarUrl":null,"authStatus":0,"expertTags":null,"experts":{"1":"泛生活视频达人","2":"生活图文达人"}},"subscribed":false,"trackCount":143,"userId":41142946,"playCount":1087349,"bookCount":5948,"specialType":0,"officialTags":null,"action":null,"actionType":null,"recommendText":null,"score":null,"description":"世界小的像一条街的布景 ，我们相遇了 ，你点点头 ，省略了所有的往事 省略了问候。","highQuality":false}]
         * playlistCount : 282
         */

        private Object searchQcReminder;
        private int playlistCount;
        private List<PlaylistsBean> playlists;

        public Object getSearchQcReminder() {
            return searchQcReminder;
        }

        public void setSearchQcReminder(Object searchQcReminder) {
            this.searchQcReminder = searchQcReminder;
        }

        public int getPlaylistCount() {
            return playlistCount;
        }

        public void setPlaylistCount(int playlistCount) {
            this.playlistCount = playlistCount;
        }

        public List<PlaylistsBean> getPlaylists() {
            return playlists;
        }

        public void setPlaylists(List<PlaylistsBean> playlists) {
            this.playlists = playlists;
        }

        public static class PlaylistsBean {
            /**
             * id : 962437258
             * name : 海阔天空【Beyond】
             * coverImgUrl : https://p1.music.126.net/4-pcFf-ZogAjRpr-Z0GSnw==/109951163045433017.jpg
             * creator : {"nickname":"大海_1995","userId":322006025,"userType":0,"avatarUrl":null,"authStatus":0,"expertTags":null,"experts":null}
             * subscribed : false
             * trackCount : 19
             * userId : 322006025
             * playCount : 1356453
             * bookCount : 15636
             * specialType : 0
             * officialTags : null
             * action : null
             * actionType : null
             * recommendText : null
             * score : null
             * description : 对于一位朋友所说的创建者用没用心我想我没必要争辩些什么，因为这本就是我的无心之举。本人07年初中受一位热爱摇滚的同学影响开始听beyond，初听只是感觉节奏很好，后来慢慢了解到歌词之后才发现都是人生真理。在人生不同时候，家驹的歌真的能听出不同的感悟，有那么几个瞬间，我感觉我跟家驹有了共鸣。而创建这个歌单，也只是把能让我听过之后有所感悟的歌曲收藏起来。刚开始真没想到会有这么多人收藏，所以这个歌单还一直是最初收藏的那些经典歌曲，最后也希望越来越多人喜欢家驹，并且听完家驹的歌之后都能有所感悟，仅此而已。
             只要大家没有忘记，家驹就一直不会死去。
             * highQuality : false
             */

            private String id;
            private String name;
            private String coverImgUrl;
            private CreatorBean creator;
            private boolean subscribed;
            private int trackCount;
            private int userId;
            private int playCount;
            private int bookCount;
            private int specialType;
            private Object officialTags;
            private Object action;
            private Object actionType;
            private Object recommendText;
            private Object score;
            private String description;
            private boolean highQuality;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCoverImgUrl() {
                return coverImgUrl;
            }

            public void setCoverImgUrl(String coverImgUrl) {
                this.coverImgUrl = coverImgUrl;
            }

            public CreatorBean getCreator() {
                return creator;
            }

            public void setCreator(CreatorBean creator) {
                this.creator = creator;
            }

            public boolean isSubscribed() {
                return subscribed;
            }

            public void setSubscribed(boolean subscribed) {
                this.subscribed = subscribed;
            }

            public int getTrackCount() {
                return trackCount;
            }

            public void setTrackCount(int trackCount) {
                this.trackCount = trackCount;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getPlayCount() {
                return playCount;
            }

            public void setPlayCount(int playCount) {
                this.playCount = playCount;
            }

            public int getBookCount() {
                return bookCount;
            }

            public void setBookCount(int bookCount) {
                this.bookCount = bookCount;
            }

            public int getSpecialType() {
                return specialType;
            }

            public void setSpecialType(int specialType) {
                this.specialType = specialType;
            }

            public Object getOfficialTags() {
                return officialTags;
            }

            public void setOfficialTags(Object officialTags) {
                this.officialTags = officialTags;
            }

            public Object getAction() {
                return action;
            }

            public void setAction(Object action) {
                this.action = action;
            }

            public Object getActionType() {
                return actionType;
            }

            public void setActionType(Object actionType) {
                this.actionType = actionType;
            }

            public Object getRecommendText() {
                return recommendText;
            }

            public void setRecommendText(Object recommendText) {
                this.recommendText = recommendText;
            }

            public Object getScore() {
                return score;
            }

            public void setScore(Object score) {
                this.score = score;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public boolean isHighQuality() {
                return highQuality;
            }

            public void setHighQuality(boolean highQuality) {
                this.highQuality = highQuality;
            }

            public static class CreatorBean {
                /**
                 * nickname : 大海_1995
                 * userId : 322006025
                 * userType : 0
                 * avatarUrl : null
                 * authStatus : 0
                 * expertTags : null
                 * experts : null
                 */

                private String nickname;
                private int userId;
                private int userType;
                private Object avatarUrl;
                private int authStatus;
                private Object expertTags;
                private Object experts;

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }

                public int getUserType() {
                    return userType;
                }

                public void setUserType(int userType) {
                    this.userType = userType;
                }

                public Object getAvatarUrl() {
                    return avatarUrl;
                }

                public void setAvatarUrl(Object avatarUrl) {
                    this.avatarUrl = avatarUrl;
                }

                public int getAuthStatus() {
                    return authStatus;
                }

                public void setAuthStatus(int authStatus) {
                    this.authStatus = authStatus;
                }

                public Object getExpertTags() {
                    return expertTags;
                }

                public void setExpertTags(Object expertTags) {
                    this.expertTags = expertTags;
                }

                public Object getExperts() {
                    return experts;
                }

                public void setExperts(Object experts) {
                    this.experts = experts;
                }
            }
        }
    }
}
