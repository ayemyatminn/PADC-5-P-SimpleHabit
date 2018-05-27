package com.padcmyanmar.simplehabit.events;



import com.padcmyanmar.simplehabit.data.vo.CategoryProgramVO;
import com.padcmyanmar.simplehabit.data.vo.CurrentProgramVO;
import com.padcmyanmar.simplehabit.data.vo.TopicesVO;

import java.util.List;

/**
 * Created by aung on 12/2/17.
 */

public class RestApiEvents {

    public static class EmptyResponseEvent {

    }

    public static class ErrorInvokingAPIEvent {
        private String errorMsg;

        public ErrorInvokingAPIEvent(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public String getErrorMsg() {
            return errorMsg;
        }
    }

    public static class TopicDataLoadedEvent {
        private int loadedPageIndex;
        private List<TopicesVO> loadTopices;

        public TopicDataLoadedEvent(int loadedPageIndex, List<TopicesVO> loadTopices) {
            this.loadedPageIndex = loadedPageIndex;
            this.loadTopices = loadTopices;
        }

        public int getLoadedPageIndex() {
            return loadedPageIndex;
        }

        public List<TopicesVO> getLoadTopices() {
            return loadTopices;
        }
    }

    public static class CurrentDataLoadedEvent {
        private int loadedCodeIndex;
        private CurrentProgramVO loadCurrent;

        public CurrentDataLoadedEvent(int loadedCodeIndex, CurrentProgramVO loadCurrent) {
            this.loadedCodeIndex = loadedCodeIndex;
            this.loadCurrent = loadCurrent;
        }

        public int getLoadedCodeIndex() {
            return loadedCodeIndex;
        }

        public CurrentProgramVO getLoadCurrent() {
            return loadCurrent;
        }
    }

    public static class CategoryDataLoadedEvent {
        private int loadedPageIndex;
        private List<CategoryProgramVO> loadCategory;

        public CategoryDataLoadedEvent(int loadedPageIndex, List<CategoryProgramVO> loadCategory) {
            this.loadedPageIndex = loadedPageIndex;
            this.loadCategory = loadCategory;
        }

        public int getLoadedPageIndex() {
            return loadedPageIndex;
        }

        public List<CategoryProgramVO> getLoadCategory() {
            return loadCategory;
        }
    }
}
