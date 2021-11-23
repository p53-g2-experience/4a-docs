from rest_framework import status, views
from rest_framework.response import Response
from dictionaryApp.models.word import Word
from dictionaryApp.DictionaryUtils import Functions_Global
from rest_framework.permissions import IsAuthenticated

from dictionaryApp.serializers.wordSerializer import WordSerializer


class WordUpdateView(views.APIView):

    permission_classes = (IsAuthenticated,)
    def put(self, request, *args, **kwargs):
        try:
            if  Functions_Global.is_Authenticated(request):
                wordInstance = Word.objects.filter(id=kwargs['pk']).first()
                serializer = WordSerializer(wordInstance, data=request.data)
                serializer.is_valid(raise_exception=True)
                wordInstance = serializer.save()
                return Response(serializer.data, status=status.HTTP_202_ACCEPTED)

        except Exception as ex:
            return Response(str(ex), status = status.HTTP_502_BAD_GATEWAY)